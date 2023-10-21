package com.api.funcionario.controllers.v1;

import com.api.funcionario.base.dtos.BaseDto;
import com.api.funcionario.entity.dto.FuncionarioRequestDto;
import com.api.funcionario.services.v1.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/funcionario",produces = {"application/json"})
public class FuncionarioController {

    final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    @Operation(summary = "Adiciona registro de um funcionário ", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Dado(s) inválido(s)"),
            @ApiResponse(responseCode = "409", description = "Registro já existente"),
            @ApiResponse(responseCode = "201", description = "Registro criado"),
    })
    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseDto> postFuncionario(@RequestBody FuncionarioRequestDto funcionarioRequestDto) {
        return funcionarioService.resgistrarFuncionario(funcionarioRequestDto);

    }
}
