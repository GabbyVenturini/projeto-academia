package com.api.fornecedor.controllers.v1;


import com.api.fornecedor.base.dto.BaseDto;
import com.api.fornecedor.entity.dtos.FornecedorRequestDto;
import com.api.fornecedor.services.v1.CadastrarFornecedorService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "API Fornecedor")
@RestController
@RequestMapping(value = "/v1/fornecedor")
public class FornecedorController {

    private CadastrarFornecedorService cadastrarFornecedorService;

    public FornecedorController(CadastrarFornecedorService cadastrarFornecedorService) {
        this.cadastrarFornecedorService = cadastrarFornecedorService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fornecedor cadastrado com sucesso.", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "string", example = "Fornecedor cadastrado com sucesso.")
                    )
            }),
            @ApiResponse(responseCode = "400", description = "E-mail já cadastrado.", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "string", example = "E-mail já  cadastrado.")
                    )
            }),
            @ApiResponse(responseCode = "400", description = "CNPJ já cadastrado.", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(type = "string", example = "CNPJ já cadastrado.")
                    )
            })
    })

    @PostMapping
    public ResponseEntity<BaseDto> cadastrarFornecedor(@RequestBody FornecedorRequestDto novoFornecedor){
        return (ResponseEntity<BaseDto>) cadastrarFornecedorService.cadastrarFornecedor(novoFornecedor);
    }
}

