package com.pgichure.ampersand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Paul
 * 
 * <p>This is the main entry class to the application
 *
 */
@EnableJpaAuditing
@SpringBootApplication
public class AmpersandApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AmpersandApplication.class, args);
	}

}
