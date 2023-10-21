package com.api.apifinanceiro.transform;

import com.api.apifinanceiro.entities.dtos.FinanceiroRequestDto;
import com.api.apifinanceiro.entities.models.FinanceiroModel;

public class FinanceiroModelTransform {

  public FinanceiroModel transformarFinanceiroModel(FinanceiroRequestDto financeiroRequestDto) {
    FinanceiroModel assinaturaModel = new FinanceiroModel();

    assinaturaModel.setIdFuncionario(financeiroRequestDto.getIdFuncionario());
    assinaturaModel.setCargo(financeiroRequestDto.getCargo());
    assinaturaModel.setDataAdmissao(financeiroRequestDto.getDataAdmissao());
    assinaturaModel.setSalario(financeiroRequestDto.getSalario());
    assinaturaModel.setClt(financeiroRequestDto.getClt());
    assinaturaModel.setMatricula(financeiroRequestDto.getMatricula());
    assinaturaModel.setStatus(1);

    if (financeiroRequestDto.getStatus() == null) {
      assinaturaModel.setStatus(1);
    } else {
      assinaturaModel.setStatus(financeiroRequestDto.getStatus());
    }

    return assinaturaModel;
  }
}
