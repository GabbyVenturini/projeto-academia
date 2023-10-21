package com.api.fornecedor.entity.dtos;


import java.io.Serializable;

public class FornecedorResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    public FornecedorResponseDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
