package camelinaction;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class EnrichFailureProcessorTest extends CamelTestSupport {

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // configure the error handler to prepare the failed exchange using the processor
                errorHandler(deadLetterChannel("mock:dead")
                        .useOriginalMessage().onPrepareFailure(new FailureProcessor()));

                from("direct:start")
                    .transform(constant("This is a changed body"))
                    .throwException(new IllegalArgumentException("Forced"));

            }
        };
    }

    @Test
    public void testEnrichFailure() throws Exception {
        // we expect the message to end up in the dead letter queue
        // is the original incoming message, and not the transformed message that happens during routing
        getMockEndpoint("mock:dead").expectedBodiesReceived("Hello World");
        // the failure processor will enrich the message and set a header with a constructed error message
        getMockEndpoint("mock:dead").expectedHeaderReceived("FailureMessage", "The message failed because Forced");

        template.sendBody("direct:start", "Hello World");

        assertMockEndpointsSatisfied();
    }
}
