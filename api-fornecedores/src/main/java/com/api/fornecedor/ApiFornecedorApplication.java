package com.api.fornecedor;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@OpenAPIDefinition(info = @Info(title = "API Fornecedor", version = "1", description = "API de fornecedor da academia."))
@SpringBootApplication
@RestController
public class ApiFornecedorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiFornecedorApplication.class, args);
    }

    @GetMapping("/olamundo")
    public String olaMundo() {
        return "API FORNECEDOR!";
    }
}