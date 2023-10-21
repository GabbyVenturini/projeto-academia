package com.api.apifinanceiro.controllers.v1;

import com.api.apifinanceiro.base.dtos.BaseDto;
import com.api.apifinanceiro.entities.dtos.FinanceiroRequestDto;
import com.api.apifinanceiro.services.v1.FinanceiroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/financeiro")
@Tag(
    name = "API Financeiro",
    description = "Microserviço financeiro para API Forma NT - Academia"
)
public class FinanceiroController {

  private FinanceiroService financeiroService;

  public FinanceiroController(FinanceiroService financeiroService) {
    this.financeiroService = financeiroService;
  }

  @Operation(
      summary = "Criar financeiro",
      description = "Cria um novo financeiro",
      method = "POST"
  )
  @ApiResponse(
      responseCode = "201",
      description = "Financeiro criado com sucesso")
  @ApiResponse(
      responseCode = "400",
      description = "Erro de validação")
  @ApiResponse(
      responseCode = "500",
      description = "Erro interno")
  @PostMapping
  public ResponseEntity<BaseDto> criarFinanceiro(
      @RequestBody FinanceiroRequestDto novoFinanceiroDto
  ) {
    return financeiroService.criarFinanceiro(novoFinanceiroDto);
  }
}