package com.api.apifinanceiro.services.v1;

import com.api.apifinanceiro.base.dtos.BaseErrorDto;
import com.api.apifinanceiro.builders.ResponseErrorBuilder;
import com.api.apifinanceiro.builders.ResponseSuccessBuilder;
import com.api.apifinanceiro.entities.dtos.FinanceiroRequestDto;
import com.api.apifinanceiro.entities.dtos.FinanceiroResponseDto;
import com.api.apifinanceiro.entities.models.FinanceiroModel;
import com.api.apifinanceiro.repositories.FinanceiroRepository;
import com.api.apifinanceiro.transform.FinanceiroModelTransform;
import com.api.apifinanceiro.validations.CriarFinanceiroValidate;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FinanceiroService {

  private FinanceiroRepository financeiroRepository;

  @Autowired
  public FinanceiroService(FinanceiroRepository financeiroRepository) {
    this.financeiroRepository = financeiroRepository;
  }

  @Transactional
  public ResponseEntity criarFinanceiro(FinanceiroRequestDto novoFinanceiroDto) {
    List<BaseErrorDto> erros = new CriarFinanceiroValidate().validar(novoFinanceiroDto);

    if (erros.size() > 0) {
      return new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, erros).get();
    }

    Optional<Boolean> existsByIdFuncionario = financeiroRepository.existsByIdFuncionario(
        novoFinanceiroDto.getIdFuncionario());

    if (existsByIdFuncionario.isPresent() && existsByIdFuncionario.get()) {
      return new ResponseErrorBuilder(HttpStatus.BAD_REQUEST,
          "Funcionário já cadastrado no financeiro!").get();
    }

    FinanceiroModel novoFinanceiro;
    novoFinanceiro = new FinanceiroModelTransform().transformarFinanceiroModel(novoFinanceiroDto);

    UUID idFinanceiro = financeiroRepository.save(novoFinanceiro).getId();

    return new ResponseSuccessBuilder<FinanceiroResponseDto>(HttpStatus.CREATED,
        new FinanceiroResponseDto(idFinanceiro.toString()), "Financeiro criado com sucesso!").get();
  }
}