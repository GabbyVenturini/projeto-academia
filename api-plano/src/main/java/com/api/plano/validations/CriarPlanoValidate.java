package com.api.plano.validations;

import com.api.plano.base.dto.BaseErrorDto;
import com.api.plano.constants.MensagensErros;
import com.api.plano.entities.dtos.PlanoRequestDto;
import com.api.plano.entities.enums.PlanosEnum;

import java.util.ArrayList;
import java.util.List;

public class CriarPlanoValidate {
    public List<BaseErrorDto> validar(PlanoRequestDto planoRequestDto){
        List<BaseErrorDto> errors = validarCamposRequeridos(planoRequestDto);
        return errors.size() > 0 ? errors : validarCamposInvalidos(planoRequestDto, errors);
    }
    private List<BaseErrorDto> validarCamposRequeridos(PlanoRequestDto planoRequestDto) {
        List<BaseErrorDto> errors = new ArrayList<>();

        if (planoRequestDto.getNome() == null) {
            errors.add(new BaseErrorDto("Nome", MensagensErros.EMPTY_FIELD));
        }
        if (planoRequestDto.getDescricao() == null || planoRequestDto.getDescricao().isEmpty()) {
            errors.add(new BaseErrorDto("Descricao", MensagensErros.EMPTY_FIELD));
        }
        if (planoRequestDto.getValor() == null) {
            errors.add(new BaseErrorDto("Valor", MensagensErros.EMPTY_FIELD));
        }
        if (planoRequestDto.getValorPromocional() == null) {
            errors.add(new BaseErrorDto("valorPromocional", MensagensErros.EMPTY_FIELD));
        }
        return errors;
    }

    private List<BaseErrorDto> validarCamposInvalidos(PlanoRequestDto planoRequestDto, List<BaseErrorDto> errors) {

        if (planoRequestDto.getValor() <= 0) {
            errors.add(new BaseErrorDto("valor", MensagensErros.INVALID_FIELD));
        }
        if (planoRequestDto.getValorPromocional() <= 0) {
            errors.add(new BaseErrorDto("valorPromocional", MensagensErros.INVALID_FIELD));
        }
        if (planoRequestDto.getValorPromocional() >= planoRequestDto.getValor()){
            errors.add(new BaseErrorDto("valorPromocional", MensagensErros.INVALID_FIELD));
        }
        if (PlanosEnum.planoEscolhido(planoRequestDto.getNome().toString()) == null) {
            errors.add(new BaseErrorDto("Nome", MensagensErros.INVALID_FIELD));
        }
        return errors;
    }
}