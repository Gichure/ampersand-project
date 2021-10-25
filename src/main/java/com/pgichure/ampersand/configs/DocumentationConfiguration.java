package com.pgichure.ampersand.configs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Paul
 *
 */
@Configuration
@EnableSwagger2
public class DocumentationConfiguration {

	private static final Contact DEFAULT_CONTACT = new Contact("Paul Gichure", "www.gichure.me.ke", "gichurepaul@gmail.com");
	private static final Set<String> DEFAULT_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));
	private static final Set<String> DEFAULT_PRODUCES = new HashSet<String>(Arrays.asList("application/json"));
	
	@Bean
	public Docket apis() {
		return new Docket(DocumentationType.SWAGGER_2)
				.produces(DEFAULT_PRODUCES)
				.consumes(DEFAULT_CONSUMES)
				.groupName("v1")
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build().apiInfo(apiMetaData());
	}
	
	private ApiInfo apiMetaData() {
		return new ApiInfoBuilder().title("Ampersand Software Engineer Project APIs")
				.description("Ampersand Software Engineer Project APIs")
				.contact(DEFAULT_CONTACT)
				.version("1.0.0").build();
	}
	
}
