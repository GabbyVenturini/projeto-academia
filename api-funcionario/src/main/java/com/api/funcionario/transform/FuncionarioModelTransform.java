package com.api.funcionario.transform;

import com.api.funcionario.entity.dto.FuncionarioRequestDto;
import com.api.funcionario.entity.enums.PermissoesEnum;
import com.api.funcionario.entity.model.FuncionarioModel;

public class FuncionarioModelTransform {
    public FuncionarioModel tranformarFuncionario(FuncionarioRequestDto funcionarioRequestDto){
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setCpf(funcionarioRequestDto.getCpf());
        funcionarioModel.setDataNascimento(funcionarioRequestDto.getDataNascimento());
        funcionarioModel.setEmail(funcionarioRequestDto.getEmail());
        funcionarioModel.setNome(funcionarioRequestDto.getNome());
        funcionarioModel.setPermissao(PermissoesEnum.PermissoesString(funcionarioRequestDto.getPermissao()));
        funcionarioModel.setStatus(funcionarioRequestDto.getStatus());
        return funcionarioModel;
    }

}
