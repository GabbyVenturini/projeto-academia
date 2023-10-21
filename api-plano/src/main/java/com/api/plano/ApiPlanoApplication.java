package com.api.plano;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "API Plano",
                version = "1",
                description = "Microserviço Plano para API Forma NT - Academia"
        ))
public class ApiPlanoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiPlanoApplication.class, args);
    }
    @GetMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
