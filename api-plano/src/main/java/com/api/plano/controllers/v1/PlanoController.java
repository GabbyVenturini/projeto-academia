package com.api.plano.controllers.v1;

import com.api.plano.base.dto.BaseDto;
import com.api.plano.entities.dtos.PlanoRequestDto;
import com.api.plano.services.v1.PlanoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/plano")
@Tag
        (
        name = "API Plano",
        description = "Microserviço Plano para API Forma NT - Academia"
)
public class PlanoController {

    private PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @Operation(
            summary = "Criar Plano",
            description = "Cria um novo plano",
            method = "POST")
    @ApiResponse(
            responseCode = "201",
            description = "Plano criado com sucesso")
    @ApiResponse(
            responseCode = "400",
            description = "Erro de validação")
    @ApiResponse(
            responseCode = "500",
            description = "Erro interno")
    @PostMapping
    public ResponseEntity<BaseDto> criarPlano(
            @RequestBody PlanoRequestDto novoPlanoDto
    ) {
        return planoService.criarPlano(novoPlanoDto);
    }
}