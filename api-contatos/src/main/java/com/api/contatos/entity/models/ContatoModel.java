package com.api.contatos.entity.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "CONTATO")
public class ContatoModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private UUID idCliente;

    @Column
    private UUID idFuncionario;

    @Column
    private UUID idFornecedor;

    @Column(nullable = false)
    private String contato;

    @Column(nullable = false, columnDefinition = "int default 1")
    private Integer status;

    public ContatoModel(
            UUID id,
            UUID idCliente,
            UUID idFuncionario,
            UUID idFornecedor,
            String contato,
            int status
    ){
        this.id = id;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.idFornecedor = idFornecedor;
        this.contato = contato;
        this.status = status;
    }

    public ContatoModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public UUID getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(UUID idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public UUID getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(UUID idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}