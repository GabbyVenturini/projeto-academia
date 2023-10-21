package com.api.fornecedor.repositories;


import com.api.fornecedor.entity.models.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FornecedorRepositories extends JpaRepository<FornecedorModel, UUID> {

    boolean existsByCnpj(String cnpj);

}

