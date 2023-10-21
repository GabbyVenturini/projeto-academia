package com.api.funcionario.validations;

import com.api.funcionario.base.dtos.BaseErrorDto;
import com.api.funcionario.entity.dto.FuncionarioRequestDto;
import com.api.funcionario.entity.enums.PermissoesEnum;
import com.api.funcionario.utils.date.DateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FuncionarioValidate {
    List<BaseErrorDto> erros = new ArrayList<>();

    public List<BaseErrorDto> validarPost(FuncionarioRequestDto funcionarioRequestDto) {
        if (funcionarioRequestDto.getNome().isBlank()) {
            erros.add(new BaseErrorDto("nome", "Nome não pode estar vazio"));
        } else if (((funcionarioRequestDto.getNome().split("\\s+").length) <= 1)
                || (funcionarioRequestDto.getNome().replaceAll("\\s", "").length() < 6)) {
            erros.add(new BaseErrorDto("nome", "Nome fora do padrão"));
        }
        if (!new DateUtils().dataIso(funcionarioRequestDto.getDataNascimento())) {
            erros.add(new BaseErrorDto("dataNascimento", "Data de nascismento fora do padrão"));
        } else if (new DateUtils().idadeMinima(funcionarioRequestDto.getDataNascimento()) < 16) {
            erros.add(new BaseErrorDto("dataNascimento", "Idade atual inválida"));
        }
        if (funcionarioRequestDto.getEmail().isBlank()) {
            erros.add(new BaseErrorDto("email", "Email não pode estar vazio"));
        } else if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", funcionarioRequestDto.getEmail())) {
            erros.add(new BaseErrorDto("email", "Email fora do padrão"));
        }
        if (funcionarioRequestDto.getCpf().isBlank()) {
            erros.add(new BaseErrorDto("cpf", "Cpf não pode estar vazio"));
        } else if (!Pattern.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", funcionarioRequestDto.getCpf())) {
            erros.add(new BaseErrorDto("cpf", "Cpf fora do padrão"));
        }
        if (funcionarioRequestDto.getPermissao().isBlank()) {
            erros.add(new BaseErrorDto("permissao", "Permissão não pode estar vazia"));
        } else if (PermissoesEnum.PermissoesString(funcionarioRequestDto.getPermissao().toLowerCase()) == null) {
            erros.add(new BaseErrorDto("permissao", "Permissão não existente"));
        }
        if (funcionarioRequestDto.getStatus() > 1){
            erros.add(new BaseErrorDto("status", "Status inválido"));
        }
        return erros;
    }

}
