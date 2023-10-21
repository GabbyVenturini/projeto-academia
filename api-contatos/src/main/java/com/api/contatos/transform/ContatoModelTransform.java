package com.api.contatos.transform;

import com.api.contatos.entity.dto.ContatoRequestDto;
import com.api.contatos.entity.models.ContatoModel;

public class ContatoModelTransform {
    public ContatoModel transformarContato(ContatoRequestDto contatoRequestDto){
        ContatoModel contatoModel = new ContatoModel();
        contatoModel.setIdCliente(contatoRequestDto.getIdCliente());
        contatoModel.setIdFuncionario(contatoRequestDto.getIdFuncionario());
        contatoModel.setIdFornecedor(contatoRequestDto.getIdFornecedor());
        contatoModel.setContato(contatoRequestDto.getContato());
        contatoModel.setStatus(contatoRequestDto.getStatus());
        return contatoModel;
    }
}
