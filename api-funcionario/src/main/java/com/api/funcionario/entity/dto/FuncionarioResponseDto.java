package com.api.funcionario.entity.dto;

import java.io.Serializable;

public class FuncionarioResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    public FuncionarioResponseDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
