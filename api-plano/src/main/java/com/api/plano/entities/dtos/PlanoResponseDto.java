package com.api.plano.entities.dtos;

import java.io.Serializable;

public class PlanoResponseDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;

    public PlanoResponseDto(
            String id
    ) {
        this.id = id;
    }

    public PlanoResponseDto() {
    }

    public String id() {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

