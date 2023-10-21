package com.api.contatos.builders;

import com.api.contatos.base.dtos.BaseDto;
import com.api.contatos.base.dtos.BaseErrorDto;
import com.api.contatos.base.dtos.BaseResultDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ResponseErrorBuilder {

    private ResponseEntity<BaseDto<Void>> resultado;

    public ResponseErrorBuilder(HttpStatus status, String mensagem) {
        BaseResultDto resultado = new BaseResultDto(status.value(), mensagem);
        // Recebe uma mensagem
        BaseDto<Void> baseDto = new BaseDto<>(null, new ArrayList<>(), resultado);
        this.resultado = ResponseEntity.status(status.value()).body(baseDto);
    }

    public ResponseErrorBuilder(HttpStatus status, List<BaseErrorDto> erros) {
        BaseResultDto resultado = new BaseResultDto(status.value(), status.getReasonPhrase());
        // Recebe um STATUS (numero)
        BaseDto<Void> baseDto = new BaseDto<>(null, erros, resultado);
        this.resultado = ResponseEntity.status(status.value()).body(baseDto);
    }

    public ResponseErrorBuilder(HttpStatus status, String mensagem, List<BaseErrorDto> erros) {
        BaseResultDto resultado = new BaseResultDto(status.value(), mensagem);
        // Recebe um STATUS (numero) e uma mensagem
        BaseDto<Void> baseDto = new BaseDto<>(null, erros, resultado);
        this.resultado = ResponseEntity.status(status.value()).body(baseDto);
    }

    public ResponseEntity<BaseDto<Void>> get() {
        return resultado;
    }
}

