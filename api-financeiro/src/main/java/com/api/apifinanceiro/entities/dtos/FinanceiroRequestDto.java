package com.api.apifinanceiro.entities.dtos;

import com.api.apifinanceiro.entities.enums.CargosEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.ZonedDateTime;
import java.util.UUID;

public class FinanceiroRequestDto {

  @Schema(
      description = "Id do funcionário",
      example = "123e4567-e89b-12d3-a456-426614174000"
  )
  private UUID idFuncionario;
  @Schema(
      description = "Cargo do funcionário",
      example = "INSTRUTOR"
  )
  private CargosEnum cargo;
  @Schema(
      description = "Data de admissão do funcionário",
      example = "2021-01-01T00:00:00.000Z"
  )
  private ZonedDateTime dataAdmissao;
  @Schema(
      description = "Salário do funcionário",
      example = "1000.00"
  )
  private Double salario;
  @Schema(
      description = "Carteira de trabalho do funcionário",
      example = "123456789"
  )
  private String clt;
  @Schema(
      description = "Matrícula",
      example = "123456789"
  )
  private String matricula;
  @Schema(
      description = "Status do funcionário",
      example = "1"
  )
  private Integer status;

  public FinanceiroRequestDto(
      UUID idFuncionario,
      CargosEnum cargo,
      ZonedDateTime dataAdmissao,
      Double salario,
      String clt,
      String matricula,
      Integer status
  ) {
    this.idFuncionario = idFuncionario;
    this.cargo = cargo;
    this.dataAdmissao = dataAdmissao;
    this.salario = salario;
    this.clt = clt;
    this.matricula = matricula;
    this.status = status;
  }

  public FinanceiroRequestDto() {
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
