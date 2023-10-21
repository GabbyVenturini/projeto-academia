package com.api.plano.entities.dtos;

import com.api.plano.entities.enums.PlanosEnum;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public class PlanoRequestDto {


    @Schema(
            description = "Id do Plano",
            example = "123e4567-e89b-12d3-a456-426614174000"
    )
    private UUID id;
    @Schema(
            description = "Nome do Plano",
            example = "BASICO"
    )
    private PlanosEnum nome;
    @Schema(
            description = "Descricao do Plano",
            example = "area de musculacao e aerobicos"
    )
    private String descricao;
    @Schema(
            description = "Valor do Plano",
            example = "100.00"
    )
    private Double valor;
    @Schema(
            description = "Valor promocional do Plano",
            example = "89.90"
    )
    private Double valorPromocional;
    @Schema(
            description = "Status do Plano",
            example = "1"
    )
    private Integer status;

    public PlanoRequestDto() {
    }

    public PlanoRequestDto(UUID id, PlanosEnum nome, String descricao, Double valor, Double valorPromocional, Integer status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.valorPromocional = valorPromocional;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PlanosEnum getNome() {
        return nome;
    }

    public void setNome(PlanosEnum nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getValorPromocional() {
        return valorPromocional;
    }

    public void setValorPromocional(Double valorPromocional) {
        this.valorPromocional = valorPromocional;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}