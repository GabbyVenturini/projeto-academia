package com.api.funcionario.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class FuncionarioRequestDto {
    @Schema(description = "Nome do funcionário", example = "Italo Alisson")
    private String nome;
    @Schema(description = "Data de nascimento", example = "1980-04-02")
    private String dataNascimento;
    @Schema(description = "Email do funcionário", example = "exemplo@gmail.com")
    private String email;
    @Schema(description = "Cpf do funcionário", example = "123.123.123-23")
    private String cpf;
    @Schema(description = " Permissão do funcionário", example = "visitante/gerente/admin")
    private String permissao;
    @Schema(description = "Status atual", example = "1")
    private Integer status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
