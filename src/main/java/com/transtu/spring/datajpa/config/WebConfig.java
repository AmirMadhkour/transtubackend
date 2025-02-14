package com.transtu.spring.datajpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allows all endpoints, including nested paths
                .allowedOrigins("http://localhost:5173") // Replace with your React app URL
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // Allowed HTTP methods
                .allowedHeaders("*") // Allows all headers
                .allowCredentials(true); // Allows credentials (like cookies)
    }
}
