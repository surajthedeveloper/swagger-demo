package com.swagger.demo.swaggerdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableWebMvc
@Configuration
public class SwaggerConfiguration {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.demo.swaggerdemo"))
                .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())

                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Swagger Demo Application")
                .description("Swagger demo application to demonstrate the functionality and documentation | New line documentation")
                .termsOfServiceUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Suraj Jannu", "https://jannusuraj.wixsite.com/resume", "jannusuraj@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .version("0.0.1")
                .build();
    }
}
