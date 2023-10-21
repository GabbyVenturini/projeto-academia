package com.api.apifinanceiro.entities.models;

import com.api.apifinanceiro.entities.enums.CargosEnum;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "FINANCEIRO")
public class FinanceiroModel implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  @Column(nullable = false)
  private UUID idFuncionario;

  @Column(nullable = false)
  private CargosEnum cargo;

  @Column(nullable = false)
  private ZonedDateTime dataAdmissao;

  @Column(nullable = false)
  private Double salario;

  @Column
  private String clt;

  @Column
  private String matricula;

  @Column
  private Integer status;

  public FinanceiroModel(
      UUID id,
      UUID idFuncionario,
      CargosEnum cargo,
      ZonedDateTime dataAdmissao,
      Double salario,
      String clt,
      String matricula,
      Integer status
  ) {
    this.id = id;
    this.idFuncionario = idFuncionario;
    this.cargo = cargo;
    this.dataAdmissao = dataAdmissao;
    this.salario = salario;
    this.clt = clt;
    this.matricula = matricula;
    this.status = status;
  }

  public FinanceiroModel() {

  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getIdFuncionario() {
    return idFuncionario;
  }

  public void setIdFuncionario(UUID idFuncionario) {
    this.idFuncionario = idFuncionario;
  }

  public CargosEnum getCargo() {
    return cargo;
  }

  public void setCargo(CargosEnum cargo) {
    this.cargo = cargo;
  }

  public ZonedDateTime getDataAdmissao() {
    return dataAdmissao;
  }

  public void setDataAdmissao(ZonedDateTime dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public Double getSalario() {
    return salario;
  }

  public void setSalario(Double salario) {
    this.salario = salario;
  }

  public String getClt() {
    return clt;
  }

  public void setClt(String clt) {
    this.clt = clt;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
