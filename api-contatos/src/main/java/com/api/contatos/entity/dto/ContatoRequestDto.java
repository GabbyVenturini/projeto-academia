package com.api.contatos.entity.dto;



import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

public class ContatoRequestDto {

    @Schema(description = "Id de um cliente", type = "string" ,example= "094dec93-cfb3-408f-af83-60050d4e40f6")
    private UUID idCliente;
    @Schema(description = "Id de um funcionário",example = "")
    private UUID idFuncionario;
    @Schema(description = "Id de um fornecedor", example = "")
    private UUID idFornecedor;
    @Schema(description = "Número ou outro tipo de contato", example = "71980028922")
    private String contato;
    @Schema(description = "Status atual", example = "1")
    private Integer status;

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public UUID getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(UUID idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public UUID getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(UUID idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
