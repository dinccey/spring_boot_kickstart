package ibmix.kickstart.bikeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class BikeshopApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BikeshopApplication.class, args);
	}

}
