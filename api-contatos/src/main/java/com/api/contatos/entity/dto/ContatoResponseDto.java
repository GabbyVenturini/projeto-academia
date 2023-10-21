package com.api.contatos.entity.dto;

import java.io.Serializable;

public class ContatoResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    public ContatoResponseDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}