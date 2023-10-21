package com.api.funcionario.services.v1;

import com.api.funcionario.base.dtos.BaseErrorDto;
import com.api.funcionario.builders.ResponseErrorBuilder;
import com.api.funcionario.builders.ResponseSuccessBuilder;
import com.api.funcionario.entity.dto.FuncionarioRequestDto;
import com.api.funcionario.entity.dto.FuncionarioResponseDto;
import com.api.funcionario.entity.model.FuncionarioModel;
import com.api.funcionario.repository.FuncionarioRepository;
import com.api.funcionario.transform.FuncionarioModelTransform;
import com.api.funcionario.validations.FuncionarioValidate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Transactional
    public ResponseEntity resgistrarFuncionario(FuncionarioRequestDto novoFuncionarioRequestDto) {
        List<BaseErrorDto> errosValidacao = new FuncionarioValidate().validarPost(novoFuncionarioRequestDto);
        if (errosValidacao.size() > 0) {
            return new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, errosValidacao).get();
        }
        List<BaseErrorDto> errosConflito = new ArrayList<>();
        if (funcionarioRepository.existsByEmail(novoFuncionarioRequestDto.getEmail())) {
            errosConflito.add(new BaseErrorDto("email", "Email já cadastrado"));
        }
        if (funcionarioRepository.existsByCpf(novoFuncionarioRequestDto.getCpf())) {
            errosConflito.add(new BaseErrorDto("cpf", "Cpf já cadastrado"));
        }
        if (errosConflito.size() == 2){
            return new ResponseErrorBuilder(HttpStatus.CONFLICT,"Registro do funcionário já existente").get();
        }
        if (!errosConflito.isEmpty()) {
            return new ResponseErrorBuilder(HttpStatus.CONFLICT, errosConflito).get();
        }


        FuncionarioModel novoFuncionario = new FuncionarioModelTransform().tranformarFuncionario(novoFuncionarioRequestDto);
        UUID idFuncionario = funcionarioRepository.save(novoFuncionario).getId();
        return new ResponseSuccessBuilder<FuncionarioResponseDto>(HttpStatus.CREATED, new FuncionarioResponseDto(idFuncionario.toString()),
                "Funcionário registrado com sucesso").get();

    }
}
