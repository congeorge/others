package camel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FiletoJMSRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/inbox?noop=true").to("file:data/outbox");
     /*           .to("jms:queue:integrationqueue");
        System.out.println("Sent file");
        from("jms:queue:integrationqueue"
               /*  .to("file:data/outbox");*/

    }
}
