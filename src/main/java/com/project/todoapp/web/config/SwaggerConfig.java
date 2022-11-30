package com.project.todoapp.web.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("todo-app")
                .pathsToMatch("/tasks/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("TaskApp")
                        .description("API REST para la gestión de tareas personales")
                        .version("v0.0.1")
                        .license(new License().name("Licencia de API").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Alexander Prado")
                        .url("https://github.com/alexanderjprado/"));
    }
}
