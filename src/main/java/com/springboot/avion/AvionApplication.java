package com.springboot.avion;

import lombok.NonNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AvionApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvionApplication.class, args);
    }

    @Bean
    WebMvcConfigurer corsConfig(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/*").allowedOriginPatterns("*").allowedOrigins("*").allowedHeaders("*").allowedMethods("*");
            }
        };
    }

}
