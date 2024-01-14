package com.gbacoder.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author alanulog
 * @create 2024-01-14
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }


    // get instance of Docket
    @Bean
    public Docket docket(Environment environment) {

        Profiles profiles = Profiles.of("dev", "test");

        boolean enableSwaggerFlag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("HelloWorld")
                .enable(enableSwaggerFlag)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gbacoder.swagger.controlller"))
                .paths(PathSelectors.ant("/hello"))
                .build();
    }

    private ApiInfo apiInfo() {

        // author info
        Contact contact = new Contact("Alan", "", "alan@gbacoder.com");

        return new ApiInfo(
                "Hello World SwaggerApi Doc",
                "Api Documentation",
                "v1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }
}
