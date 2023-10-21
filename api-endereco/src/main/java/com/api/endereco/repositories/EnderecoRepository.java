package com.api.endereco.repositories;

import com.api.endereco.entity.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoModel, UUID> {

    Optional<Boolean> existsByIdCliente(UUID idCliente);

    Optional<Boolean> existsByIdFuncionario(UUID idFuncionario);

    Optional<Boolean> existsByIdFornecedor(UUID idFornecedor);
}
