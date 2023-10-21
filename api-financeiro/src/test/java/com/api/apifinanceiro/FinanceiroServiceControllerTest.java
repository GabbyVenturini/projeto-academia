package com.api.apifinanceiro;

import static org.junit.jupiter.api.Assertions.fail;

import com.api.apifinanceiro.controllers.v1.FinanceiroController;
import com.api.apifinanceiro.services.v1.FinanceiroService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
@DisplayName("FinanceiroServiceController - Testes")
public class FinanceiroServiceControllerTest {

  @Autowired
  ApplicationContext context;

  @Test
  @DisplayName("01 - Classe da camada serviço criada corretamente")
  void testServiceClassExists() {
    try {
      context.getBean(FinanceiroService.class);
    } catch (NoSuchBeanDefinitionException exc) {
      fail("Classe da camada serviço deve existir e ser implementada de forma correta");
    }
  }

  @Test
  @DisplayName("02 - Classe da camada controle criada corretamente")
  void testControllerClassExists() {
    try {
      context.getBean(FinanceiroController.class);
    } catch (NoSuchBeanDefinitionException exc) {
      fail("Classe da camada controle deve existir e ser implementada de forma correta");
    }
  }
}
