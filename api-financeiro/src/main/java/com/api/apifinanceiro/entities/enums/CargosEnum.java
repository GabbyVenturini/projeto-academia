package com.api.apifinanceiro.entities.enums;

public enum CargosEnum {
  INSTRUTOR("INSTRUTOR"),
  RECEPCIONISTA("RECEPCIONISTA"),
  SERVICOS_GERAIS("SERVICOS_GERAIS"),
  FINANCEIRO("FINANCEIRO");

  String cargoEscolhido;

  CargosEnum(String cargoEscolhido) {
    this.cargoEscolhido = cargoEscolhido;
  }

  public static CargosEnum cargoSelecionado(String cargoEscolhido) {
    CargosEnum[] var1 = values();
    int var2 = var1.length;

    for (int var3 = 0; var3 < var2; ++var3) {
      CargosEnum cargosEnum = var1[var3];
      if (cargosEnum.getCargoEscolhido().equals(cargoEscolhido)) {
        return cargosEnum;
      }
    }

    return null;
  }

  public String getCargoEscolhido() {
    return cargoEscolhido;
  }

  public void setCargoEscolhido(String cargoEscolhido) {
    this.cargoEscolhido = cargoEscolhido;
  }
}
