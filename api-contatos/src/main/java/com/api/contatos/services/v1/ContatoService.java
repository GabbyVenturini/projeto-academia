package com.api.contatos.services.v1;

import com.api.contatos.base.dtos.BaseDto;
import com.api.contatos.base.dtos.BaseErrorDto;
import com.api.contatos.builders.ResponseErrorBuilder;
import com.api.contatos.builders.ResponseSuccessBuilder;
import com.api.contatos.constants.ErrosConstants;
import com.api.contatos.entity.dto.ContatoRequestDto;
import com.api.contatos.entity.dto.ContatoResponseDto;
import com.api.contatos.entity.models.ContatoModel;
import com.api.contatos.repositories.ContatoRepository;
import com.api.contatos.transform.ContatoModelTransform;
import com.api.contatos.validations.ContatoValidate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContatoService {

    private ContatoRepository contatoRepository;
    @Autowired
    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Transactional
    public ResponseEntity resgistrarContato(ContatoRequestDto novoContatoRequestDto) {
        List<BaseErrorDto> errosValidacao = new ContatoValidate().validarPost(novoContatoRequestDto);
        if (errosValidacao.size() > 0) {
            return new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, errosValidacao).get();
        }
        if (contatoRepository.existsByContato(novoContatoRequestDto.getContato())){
            BaseErrorDto erroConflito = new BaseErrorDto("contato", ErrosConstants.CADASTRO_EXISTENTE);
             return new ResponseEntity<BaseErrorDto>(erroConflito,HttpStatus.CONFLICT);
        }
        ContatoModel novoContato = new ContatoModelTransform().transformarContato(novoContatoRequestDto);
        UUID idContato = contatoRepository.save(novoContato).getId();
        return new ResponseSuccessBuilder<ContatoResponseDto>(HttpStatus.CREATED,new ContatoResponseDto(idContato.toString()),
                "Contato registrado com sucesso").get();

    }
}
