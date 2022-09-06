package ibmix.kickstart.bikeshop;

import ibmix.kickstart.bikeshop.data.entities.Bicikl;
import org.atmosphere.interceptor.AtmosphereResourceStateRecovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BikeshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BikeshopApplication.class, args);
	}

}
