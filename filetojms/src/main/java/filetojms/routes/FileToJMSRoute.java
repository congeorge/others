package filetojms.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class FileToJMSRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
    from("file://data/outbox").to("jms:integrationqueue");
    }

}
