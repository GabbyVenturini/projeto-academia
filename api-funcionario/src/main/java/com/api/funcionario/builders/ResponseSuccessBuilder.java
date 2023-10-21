package com.api.funcionario.builders;

import com.api.funcionario.base.dtos.BaseDto;
import com.api.funcionario.base.dtos.BaseResultDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public class ResponseSuccessBuilder<T> { // Recebe um genérico

    private ResponseEntity<BaseDto<T>> resultado;

    public ResponseSuccessBuilder(HttpStatus status, T dados, String mensagem) {
        BaseResultDto resultado = new BaseResultDto(status.value(), mensagem);
        // Recebe um STATUS (numero) e uma mensagem
        BaseDto<T> baseDto = new BaseDto<>(dados, new ArrayList<>(), resultado);
        this.resultado = ResponseEntity.status(status.value()).body(baseDto);
    }

    public ResponseSuccessBuilder(HttpStatus status, T dados) {
        BaseResultDto resultado = new BaseResultDto(status.value(), status.getReasonPhrase());
        // Recebe um STATUS (numero)
        BaseDto<T> baseDto = new BaseDto<>(dados, new ArrayList<>(), resultado);
        this.resultado = ResponseEntity.status(status.value()).body(baseDto);
    }

    public ResponseEntity<BaseDto<T>> get() {
        return resultado;
    }
}
