package com.api.apifinanceiro.builders;

import com.api.apifinanceiro.base.dtos.BaseDto;
import com.api.apifinanceiro.base.dtos.BaseErrorDto;
import com.api.apifinanceiro.base.dtos.BaseResultDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

public class ResponseErrorBuilder {

  private ResponseEntity<BaseDto<Void>> resultado;

  public ResponseErrorBuilder(HttpStatus status, String mensagem) {
    BaseResultDto resultado = new BaseResultDto(status.value(), mensagem);
    BaseDto<Void> baseDto = new BaseDto<>(null, new ArrayList<>(), resultado);
    this.resultado = ResponseEntity.status(status.value()).body(baseDto);
  }

  public ResponseErrorBuilder(HttpStatus status, List<BaseErrorDto> erros) {
    BaseResultDto resultado = new BaseResultDto(status.value(), status.getReasonPhrase());
    BaseDto<Void> baseDto = new BaseDto<>(null, erros, resultado);
    this.resultado = ResponseEntity.status(status.value()).body(baseDto);
  }

  public ResponseErrorBuilder(HttpStatus status, String mensagem, List<BaseErrorDto> erros) {
    BaseResultDto resultado = new BaseResultDto(status.value(), mensagem);
    BaseDto<Void> baseDto = new BaseDto<>(null, erros, resultado);
    this.resultado = ResponseEntity.status(status.value()).body(baseDto);
  }

  public ResponseEntity<BaseDto<Void>> get() {
    return resultado;
  }
}