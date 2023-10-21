package com.api.plano.transformer;

import com.api.plano.entities.dtos.PlanoRequestDto;
import com.api.plano.entities.models.PlanoModel;

public class PlanoModelTransform {

    public PlanoModel transformarPlanoModel(PlanoRequestDto planoRequestDto) {
        PlanoModel planoModel = new PlanoModel();

        planoModel.setNome(planoRequestDto.getNome());
        planoModel.setDescricao(planoRequestDto.getDescricao());
        planoModel.setValor(planoRequestDto.getValor());
        planoModel.setValorPromocional(planoRequestDto.getValorPromocional());
        planoModel.setStatus(1);

        if (planoRequestDto.getStatus() == null) {
            planoModel.setStatus(1);
        } else {
            planoModel.setStatus(planoRequestDto.getStatus());
        }

        return planoModel;
    }
}