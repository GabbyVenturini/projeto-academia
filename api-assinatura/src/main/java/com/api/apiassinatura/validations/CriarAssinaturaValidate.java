package com.api.apiassinatura.validations;

import com.api.apiassinatura.base.dtos.BaseErrorDto;
import com.api.apiassinatura.constants.MensagensErros;
import com.api.apiassinatura.entities.dtos.AssinaturaRequestDto;
import java.util.ArrayList;
import java.util.List;

public class CriarAssinaturaValidate {

  public List<BaseErrorDto> validar(AssinaturaRequestDto assinaturaRequestDto) {
    List<BaseErrorDto> erros = validarCamposRequeridos(assinaturaRequestDto);
    return erros;
  }

  private List<BaseErrorDto> validarCamposRequeridos(AssinaturaRequestDto assinaturaRequestDto) {
    List<BaseErrorDto> erros = new ArrayList<>();

    // Campos obrigatórios
    if (assinaturaRequestDto.getIdPlano() == null) {
      erros.add(new BaseErrorDto("idPlano", MensagensErros.EMPTY_FIELD));
    }

    if (assinaturaRequestDto.getIdCliente() == null) {
      erros.add(new BaseErrorDto("idCliente", MensagensErros.EMPTY_FIELD));
    }

    return erros;
  }
}
