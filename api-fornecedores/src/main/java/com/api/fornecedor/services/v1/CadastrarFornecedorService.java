package com.api.fornecedor.services.v1;

import com.api.fornecedor.base.dto.BaseErrorDto;
import com.api.fornecedor.builder.ResponseErrorBuilder;
import com.api.fornecedor.builder.ResponseSuccessBuilder;
import com.api.fornecedor.entity.dtos.FornecedorResponseDto;
import com.api.fornecedor.entity.dtos.FornecedorRequestDto;
import com.api.fornecedor.entity.models.FornecedorModel;
import com.api.fornecedor.repositories.FornecedorRepositories;
import com.api.fornecedor.transform.FornecedorModelTransform;
import com.api.fornecedor.validate.CadastrarFornecedorValidate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CadastrarFornecedorService {

    private FornecedorRepositories fornecedorRepository;

    @Autowired
    public CadastrarFornecedorService(FornecedorRepositories fornecedorRepositories) {
        this.fornecedorRepository = fornecedorRepositories;
    }

    @Transactional
    public ResponseEntity<?> cadastrarFornecedor(FornecedorRequestDto novoDadosFornecedorDto) {
        List<BaseErrorDto> erros = new CadastrarFornecedorValidate().validate(novoDadosFornecedorDto);
        if (erros.size() > 0) {
            ResponseErrorBuilder resultado = new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, erros);
            return resultado.get();
        }

        boolean existsByCnpj = fornecedorRepository.existsByCnpj(novoDadosFornecedorDto.getCnpj());

        if (existsByCnpj) {
            return new ResponseErrorBuilder(
                    HttpStatus.BAD_REQUEST,
                    "Fornecedor já cadastrado"
            ).get();
        }

        FornecedorModel novoFornecedor = new FornecedorModelTransform().transformarFornecedorModel(novoDadosFornecedorDto);

        UUID idFornecedor = fornecedorRepository.save(novoFornecedor).getId();
        return new ResponseSuccessBuilder<FornecedorResponseDto>(
                HttpStatus.CREATED, new FornecedorResponseDto(idFornecedor.toString()), "Fornecedor Criado com Sucesso"
        ).get();
    }
}
