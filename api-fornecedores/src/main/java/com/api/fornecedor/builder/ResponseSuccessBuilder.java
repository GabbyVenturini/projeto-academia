package com.api.fornecedor.builder;


import com.api.fornecedor.base.dto.BaseDto;
import com.api.fornecedor.base.dto.BaseResultDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;

public class ResponseSuccessBuilder<T> {

    private ResponseEntity<BaseDto<T>> resultado;

    public ResponseSuccessBuilder(HttpStatus status, T dados, String mensagem) {
        BaseResultDto resultado = new BaseResultDto(status.value(), mensagem);
        BaseDto<T> baseDto = new BaseDto<>(dados, new ArrayList<>(), resultado);
        this.resultado = ResponseEntity.status(status.value()).body(baseDto);
    }

    public ResponseSuccessBuilder(HttpStatus status, T dados) {
        BaseResultDto resultado = new BaseResultDto(status.value(), status.getReasonPhrase());
        BaseDto<T> baseDto = new BaseDto<>(dados, new ArrayList<>(), resultado);
        this.resultado = ResponseEntity.status(status.value()).body(baseDto);
    }

    public ResponseEntity<BaseDto<T>> get() {
        return resultado;
    }
}