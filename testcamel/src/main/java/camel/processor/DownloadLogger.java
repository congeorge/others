package camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class DownloadLogger implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String message = (String) exchange.getIn().getBody(String.class);
        System.out.println("Recieve : "+message);

    }
}
