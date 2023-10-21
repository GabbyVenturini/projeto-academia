package com.api.apifinanceiro.validations;

import com.api.apifinanceiro.base.dtos.BaseErrorDto;
import com.api.apifinanceiro.constants.MensagensErros;
import com.api.apifinanceiro.entities.dtos.FinanceiroRequestDto;
import com.api.apifinanceiro.entities.enums.CargosEnum;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriarFinanceiroValidate {

  public List<BaseErrorDto> validar(FinanceiroRequestDto financeiroRequestDto) {
    List<BaseErrorDto> errors = validarCamposRequeridos(financeiroRequestDto);
    return errors.size() > 0 ? errors : validarCamposInvalidos(financeiroRequestDto, errors);
  }

  private List<BaseErrorDto> validarCamposRequeridos(FinanceiroRequestDto financeiroRequestDto) {
    List<BaseErrorDto> errors = new ArrayList<>();

    // Campos obrigatórios
    if (financeiroRequestDto.getIdFuncionario() == null) {
      errors.add(new BaseErrorDto("idFuncionario", MensagensErros.EMPTY_FIELD));
    }

    if (financeiroRequestDto.getCargo() == null) {
      errors.add(new BaseErrorDto("cargo", MensagensErros.EMPTY_FIELD));
    }

    if (financeiroRequestDto.getDataAdmissao() == null) {
      errors.add(new BaseErrorDto("dataAdmissao", MensagensErros.EMPTY_FIELD));
    }

    if (financeiroRequestDto.getSalario() == null) {
      errors.add(new BaseErrorDto("salario", MensagensErros.EMPTY_FIELD));
    }

    return errors;
  }

  private List<BaseErrorDto> validarCamposInvalidos(FinanceiroRequestDto financeiroRequestDto,
      List<BaseErrorDto> errors) {

    // Data de admissão não pode ser maior que hoje
    if (financeiroRequestDto.getDataAdmissao().isAfter(ZonedDateTime.now())) {
      errors.add(new BaseErrorDto("dataAdmissao", MensagensErros.INVALID_FIELD));
    }

    // Cargo deve ser um dos existentes
    if (CargosEnum.cargoSelecionado(financeiroRequestDto.getCargo().toString()) == null) {
      errors.add(new BaseErrorDto("cargo", MensagensErros.INVALID_FIELD));
    }

    return errors;
  }
}
