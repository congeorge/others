package camel;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Configuration;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.ConnectionFactory;
import javax.xml.bind.annotation.XmlType;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@Configuration
public class Main {
    public static void main(String[] args) throws Exception {
               SpringApplication.run(Main.class, args);

 /*   ApplicationContext context =
                new ClassPathXmlApplicationContext("springconfiguration.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(context, false);
        camelContext.start();
        Map<String,RouteBuilder> map= context.getBeansOfType(RouteBuilder.class);
        System.out.println(map);
        Thread.sleep(5000);
        camelContext.close();
*/

    }
}