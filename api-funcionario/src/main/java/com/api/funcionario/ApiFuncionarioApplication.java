package com.api.funcionario;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = " API Funcionário", version = "1", description = "API Funcionário Academia Forma-Nt"))
@RestController
public class ApiFuncionarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiFuncionarioApplication.class, args);
    }

    @GetMapping("/")
    public String teste() {
        return "Hello World!!!!";
    }
}
