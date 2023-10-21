package com.api.dadosbancarios.repository;

import com.api.dadosbancarios.entity.model.DadosBancariosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface DadosBancariosRepository extends JpaRepository<DadosBancariosModel, UUID> {

    Optional<Boolean> existsByNome(String nome);

    Optional<Boolean> existsByConta(String conta);

    Optional<Boolean> existsByBanco(String banco);

    Optional<Boolean> existsByValidade(ZonedDateTime validade);

    Optional<Boolean> existsByAgencia(String agencia);

    boolean existsById(UUID idFuncionario);
}
