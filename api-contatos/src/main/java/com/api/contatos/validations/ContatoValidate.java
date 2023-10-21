package com.api.contatos.validations;

import com.api.contatos.base.dtos.BaseErrorDto;
import com.api.contatos.constants.ErrosConstants;
import com.api.contatos.entity.dto.ContatoRequestDto;

import java.util.ArrayList;
import java.util.List;

public class ContatoValidate {
    List<BaseErrorDto> erros = new ArrayList<>();

    public List<BaseErrorDto> validarPost(ContatoRequestDto contatoRequestDto) {
        List<String> listaIds = new ArrayList<>();
        if (contatoRequestDto.getIdCliente() != null && !contatoRequestDto.getIdCliente().toString().isEmpty()) {
            listaIds.add(contatoRequestDto.getIdCliente().toString());
        }
        if (contatoRequestDto.getIdFuncionario() != null && !contatoRequestDto.getIdFuncionario().toString().isEmpty()) {
            listaIds.add(contatoRequestDto.getIdFuncionario().toString());
        }
        if ( contatoRequestDto.getIdFornecedor() != null && !contatoRequestDto.getIdFornecedor().toString().isEmpty()) {
            listaIds.add(contatoRequestDto.getIdFornecedor().toString());
        }
        if (listaIds.isEmpty()) {
            erros.add(new BaseErrorDto("Id", ErrosConstants.CAMPO_VAZIO));
        } else {
            int contador = 0;
            int id = 0;
            for (int i = 0; i < listaIds.size(); i++) {
                if (!listaIds.get(i).isBlank()) {
                    id = i;
                    if (contador > 0) {
                        erros.add(new BaseErrorDto("Id", ErrosConstants.ID_EXCEDENTE));
                        break;
                    } else {
                        contador++;
                    }
                }
            }
        }
        if (contatoRequestDto.getContato().isBlank()){
            erros.add(new BaseErrorDto("contato",ErrosConstants.CAMPO_VAZIO));
        }
        if (contatoRequestDto.getStatus() > 1){
            erros.add(new BaseErrorDto("status", ErrosConstants.CAMPO_INVALIDO));
        }
        return erros;
    }
}
