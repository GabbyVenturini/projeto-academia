package com.api.cliente.entity.dtos;

public class ClienteResponseDto {

    private String clienteId;
    private String nome;
    private String email;
    private String senhaCatraca;

    public ClienteResponseDto() {
    }

    public ClienteResponseDto(String clienteId) {
        this.clienteId = clienteId;
    }

    public ClienteResponseDto(String nome, String email, String senhaCatraca) {
        this.nome = nome;
        this.email = email;
        this.senhaCatraca = senhaCatraca;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaCatraca() {
        return senhaCatraca;
    }

    public void setSenhaCatraca(String senhaCatraca) {
        this.senhaCatraca = senhaCatraca;
    }
}
