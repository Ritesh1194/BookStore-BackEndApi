package com.bookstore.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static springfox.documentation.builders.PathSelectors.regex;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*****************************************************************************************************
 * SwaggerWeb Application Configuration For Project Controller Paths.
 *
 * @version 1.1
 * SwaggerWeb Appliaction Configuration For Project Controller Paths. 
 *  
 * @author Rupesh Patil & Durgasankar Mishra
 * @version 1.0
 * @created 2020-04-11
 * @updated 2020-05-05
 * @modified -> api documentation for swagger added.
 * @see {@link Docket} swagger SwaggerConfiguration class
 * 
 ******************************************************************************************************/
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.bookstore.user.controller")).paths(regex("/users.*"))
				.build()
				.apiInfo (apiInfo ());
	}

	/**
	 * Documentation for swagger api
	 *
	 * @return ApiInfo
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder ()
				.title ("Book Store Application")
				.description ("Book Store Shopping cart application with registration management APi")
				.license ("Apache 2.0").licenseUrl ("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version ("1.0.0")
				.build ();
	}
}
