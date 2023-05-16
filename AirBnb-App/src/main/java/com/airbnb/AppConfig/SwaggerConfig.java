package com.airbnb.AppConfig;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
public static final String AUTHORIZATION_HEADER ="Authorization";
	
	private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
        
    }
	
	private List<SecurityContext> securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(Arrays.asList(defaultAuth()))
//                .forPaths(PathSelectors.any())
//                .build();
		
		
		return Arrays.asList(SecurityContext.builder().securityReferences(defaultAuth()).build());
    }
	
	
	List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[]{authorizationScope};
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    
	}
	
	
	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo())
        .securitySchemes(Arrays.asList(apiKey()))
        .securityContexts(securityContext());
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact(
		        "Nitesh Kumar Pal",
		        "https://github.com/niteshpalcode",
		        "niteshpal.1996pal@gmail.com"
		    );
		
		 return new ApiInfoBuilder()
	                .title("AIRBNB database")
	                .description("This Project is developed by Nitesh Kumar Pal")
	                .version("1.0.0")
	                .contact(contact)
	                .license("Licence of APIS")
	                .build();
	}

}
