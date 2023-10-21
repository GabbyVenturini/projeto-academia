package com.api.fornecedor.entity.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "Fornecedor")
public class FornecedorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String nomeResponsavel;
    @Column(nullable = false)
    private String razaoSocial;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    @Size(min = 14, max = 14)
    @Pattern(regexp = "^[0-9]{14}$") //usada para validar o conteúdo de uma string
    private String cnpj;

    @Column(nullable = false)
    private Integer status;

    public FornecedorModel() {
    }
    public FornecedorModel(
            UUID id,
            String nomeResponsavel,
            String razaoSocial,
            String email,
            String cnpj,
            Integer status) {
        this.id = id;
        this.nomeResponsavel = nomeResponsavel;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.cnpj = cnpj;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}