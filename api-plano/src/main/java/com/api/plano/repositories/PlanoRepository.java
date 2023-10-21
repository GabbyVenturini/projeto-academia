package com.api.plano.repositories;


import com.api.plano.entities.enums.PlanosEnum;
import com.api.plano.entities.models.PlanoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlanoRepository extends JpaRepository<PlanoModel, UUID> {
    Optional<Boolean> existsByNome(PlanosEnum nome);
}