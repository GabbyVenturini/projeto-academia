package com.api.apifinanceiro;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@OpenAPIDefinition(
    info = @Info(
        title = "API Financeiro",
        version = "1",
        description = "Microserviço financeiro para API Forma NT - Academia"
    ))

public class ApiFinanceiroApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiFinanceiroApplication.class, args);
  }

  @GetMapping("/")
  public String hello() {
    return "Hello World!";
  }
}
