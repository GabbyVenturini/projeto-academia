package com.api.contatos.controllers.v1;

import com.api.contatos.base.dtos.BaseDto;
import com.api.contatos.entity.dto.ContatoRequestDto;
import com.api.contatos.services.v1.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/contato",produces = {"application/json"})
public class ContatoController {
    final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }
    @Operation(summary = "Adiciona registro de um contato ", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Dado(s) inválido(s)"),
            @ApiResponse(responseCode = "409", description = "Registro já existente"),
            @ApiResponse(responseCode = "201", description = "Registro criado"),
    })
    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseDto> postContato(@RequestBody ContatoRequestDto  contatoRequestDto) {
        return contatoService.resgistrarContato(contatoRequestDto);

    }

}
