package com.api.fornecedor.validate;


import com.api.fornecedor.base.dto.BaseErrorDto;
import com.api.fornecedor.entity.dtos.FornecedorRequestDto;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CadastrarFornecedorValidate {

    public List<BaseErrorDto> validate(FornecedorRequestDto fornecedorRequestDto) {
        List<BaseErrorDto> erros = validateCamposRequeridos(fornecedorRequestDto);
        return erros.size() > 0 ? erros : validateCamposInvalidos(fornecedorRequestDto, erros);
    }

    public List<BaseErrorDto> validateCamposRequeridos(FornecedorRequestDto fornecedorRequestDto) {
        List<BaseErrorDto> erros = new ArrayList<>();

        if (fornecedorRequestDto.getEmail() == null || fornecedorRequestDto.getEmail().isEmpty()) {
            erros.add(new BaseErrorDto("email", "Campo obrigatório"));
        }
        if (fornecedorRequestDto.getCnpj() == null || fornecedorRequestDto.getCnpj().isEmpty()) {
            erros.add(new BaseErrorDto("cnpj", "Campo obrigatório"));
        }

        if (fornecedorRequestDto.getRazaoSocial() == null || fornecedorRequestDto.getRazaoSocial().isEmpty()) {
            erros.add(new BaseErrorDto("razaoSocial", "Campo obrigatório"));
        }

        if (fornecedorRequestDto.getNomeResponsavel() == null || fornecedorRequestDto.getNomeResponsavel().isEmpty()) {
            erros.add(new BaseErrorDto("nomeResponsavel", "Campo obrigatório"));
        }

        return erros;
    }

    public List<BaseErrorDto> validateCamposInvalidos(
            FornecedorRequestDto fornecedorRequestDto,
            List<BaseErrorDto> erros) {
        if ((
                (fornecedorRequestDto.getNomeResponsavel().split("\\s+").length) <= 1)
                || (fornecedorRequestDto.getNomeResponsavel().replaceAll("\\s", "").length() < 6)) {
            erros.add(new BaseErrorDto("nomeResponsavel", "Campo fora do padrão."));
        }
        if (!Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(fornecedorRequestDto.getEmail()).matches()) {
            erros.add(new BaseErrorDto("email", "Campo fora do padrão."));
        }
        if (!Pattern.compile("^[0-9]{14}$").matcher(fornecedorRequestDto.getCnpj()).matches()) {
            erros.add(new BaseErrorDto("cnpj", "Campo fora do padrão."));
        }
        if (fornecedorRequestDto.getStatus() == null || fornecedorRequestDto.getStatus() != 1) {
            erros.add(new BaseErrorDto("status", "Campo fora do padrão."));

        }
        return erros;
    }
}