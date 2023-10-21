package com.api.fornecedor.transform;


import com.api.fornecedor.entity.dtos.FornecedorRequestDto;
import com.api.fornecedor.entity.models.FornecedorModel;

public class FornecedorModelTransform {

    public FornecedorModel transformarFornecedorModel(FornecedorRequestDto fornecedorRequestDto) {
        FornecedorModel assinaturaModel = new FornecedorModel();

        assinaturaModel.setNomeResponsavel(fornecedorRequestDto.getNomeResponsavel());
        assinaturaModel.setRazaoSocial(fornecedorRequestDto.getRazaoSocial());
        assinaturaModel.setEmail(fornecedorRequestDto.getEmail());
        assinaturaModel.setCnpj(fornecedorRequestDto.getCnpj());

        if (fornecedorRequestDto.getStatus() == null) {
            assinaturaModel.setStatus(1);
        } else {
            assinaturaModel.setStatus(fornecedorRequestDto.getStatus());
        }

        return assinaturaModel;
    }
}
