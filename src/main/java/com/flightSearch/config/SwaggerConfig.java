package com.flightSearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author t158909
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger.api.title}")
	private String title;

	@Value("${swagger.api.description}")
	private String description;

	@Value("${swagger.api.version}")
	private String version;

	@Value("${swagger.api.controller.basepackage}")
	private String basePackage;

	@Bean
	public Docket matchingApi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(PathSelectors.ant("/**")).build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title(title).description(description)
				.version(version).build();
	}
}
