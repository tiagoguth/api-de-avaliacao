package com.projeto.avalicao.apideavaicao.swagger;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
	@Bean
	public Docket apiDeAvaliacao() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.projeto.avalicao.apideavaicao"))
				.paths(PathSelectors.regex("/.*"))
				.build()
				.apiInfo(metaInfo());

	}
	
	private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
        		"Api de Avaliação", 
        		"Java Spring Boot", 
        		"1.0", 
        		"Terms", 
        		new Contact("Tiago Luiz Guth", "tiago.guth@compasso.com.br", "tiago.guth"), 
        		null, 
        		null, 
        		new ArrayList<VendorExtension>());
        return apiInfo;
    }
}
