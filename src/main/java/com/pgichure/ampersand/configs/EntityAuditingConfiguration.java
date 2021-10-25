package com.pgichure.ampersand.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Paul
 * <p> This is the configuration used to enable entities auditing
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class EntityAuditingConfiguration {

	@Bean
    public AuditorAware<String> auditorProvider() {
		return null;
    }
	 
}
