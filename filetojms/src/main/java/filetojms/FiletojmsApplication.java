package filetojms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:activemq-jms-spring-context.xml")
public class FiletojmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiletojmsApplication.class, args);
	}

}
