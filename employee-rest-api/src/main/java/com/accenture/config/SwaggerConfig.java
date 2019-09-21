package com.accenture.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	public Docket customerApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.accenture")).build().apiInfo(metaData());

	}
	
	private ApiInfo metaData()
	{
		ApiInfo apiInfo=new ApiInfo("Spring Boot Rest", "Accenture Employee api", "1.0", "terms Of Service Url",
				new Contact("Pradeep", "http://hcl.com", "pradeep.s@hcl.com"), "Apache",
				"https://www.apache.org/licenses/LICENSE-2.0");
		
		return apiInfo;
	}

}
