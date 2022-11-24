package com.mfpe.claimsmicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class ClaimConfig {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Claim Service").apiInfo(apiInfo()).select()
				.paths(regex("/claim.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Claim Service")
				.description("To Store the Claims and view the status of the claim")
				.termsOfServiceUrl("")
				.license("")
				.licenseUrl("").version("1.0").build();
	}
}

