package com.capston_design.fkiller.itoms.ticket_core.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Ticket Core API Document",
                version = "1.0",
                description = "Itoms Ticket Core 기능을 수행하는 API document 페이지 입니다"
        )
)
public class SwaggerConfig {
    @Bean
    public OpenAPI serviceDeskOpenAPI() {
        return new OpenAPI();
    }
}