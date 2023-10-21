 package com.api.plano.services.v1;

import com.api.plano.base.dto.BaseErrorDto;
import com.api.plano.builders.ResponseErrorBuilder;
import com.api.plano.builders.ResponseSuccessBuilder;
import com.api.plano.entities.dtos.PlanoRequestDto;
import com.api.plano.entities.dtos.PlanoResponseDto;
import com.api.plano.entities.models.PlanoModel;
import com.api.plano.repositories.PlanoRepository;
import com.api.plano.transformer.PlanoModelTransform;
import com.api.plano.validations.CriarPlanoValidate;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 @Service
 public class PlanoService {

     private PlanoRepository planoRepository;

     @Autowired
     public PlanoService(PlanoRepository planoRepository) {
         this.planoRepository = planoRepository;
     }

     @Transactional
     public ResponseEntity criarPlano(PlanoRequestDto novoPlanoDto) {
         List<BaseErrorDto> erros = new CriarPlanoValidate().validar(novoPlanoDto);

         if (erros.size() > 0) {
             return new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, erros).get();
         }

         Optional<Boolean> existsByNome = planoRepository.existsByNome(
                 novoPlanoDto.getNome());

         if (existsByNome.isPresent() && existsByNome.get()) {
             return new ResponseErrorBuilder(HttpStatus.BAD_REQUEST,
                     "Plano já cadastrado!").get();
         }

         PlanoModel novoPlano;
         novoPlano = new PlanoModelTransform().transformarPlanoModel(novoPlanoDto);

         UUID id = planoRepository.save(novoPlano).getId();

         return new ResponseSuccessBuilder<PlanoResponseDto>(HttpStatus.CREATED,
                 new PlanoResponseDto(id.toString()), "Plano criado com sucesso!").get();
     }
 }