package com.capston_design.fkiller.itoms.ticket_core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Value("${cors.allowed.path}")
    private String allowedPath;

    @Value("${cors.allowed.pattern}")
    private String allowedPattern;

    @Value("${cors.allowed.method}")
    private String allowedMethod;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(allowedPath)
                .allowedOriginPatterns(allowedPattern)
                .allowedMethods(allowedMethod)
                .allowCredentials(true);

    }
}
