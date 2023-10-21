package com.api.fornecedor.entity.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

public class FornecedorRequestDto {

    @Schema(
            description = "Nome do CNPJ",
            example = "12.330.846/0001-82"
    )
    private String cnpj;

    @Schema(
            description = "E-mail",
            example = "julianosonegors@gmail.com"
    )
    private String email;

    @Schema(
            description = "nomeResponsavel",
            example = "Juliano Sonego"
    )
    private String nomeResponsavel;

    @Schema(
            description = "nomeResponsavel",
            example = "Juliano Sonego"
    )

    private String razaoSocial;


    private Integer status;


    public FornecedorRequestDto() {

    }

    public FornecedorRequestDto(String cnpj, String email, String nomeResponsavel, String razaoSocial, Integer status) {
        this.cnpj = cnpj;
        this.email = email;
        this.nomeResponsavel = nomeResponsavel;
        this.razaoSocial = razaoSocial;
        this.status = status;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}