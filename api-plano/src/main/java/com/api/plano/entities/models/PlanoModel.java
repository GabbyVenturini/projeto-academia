package com.api.plano.entities.models;

import com.api.plano.entities.enums.PlanosEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "PLANOS")
public class PlanoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private PlanosEnum nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private Double valorPromocional;

    @Column(nullable = false)
    private Integer status;

    public PlanoModel(UUID id, PlanosEnum nome, String descricao, Double valor, Double valorPromocional, Integer status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.valorPromocional = valorPromocional;
        this.status = status;
    }

    public PlanoModel() {
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