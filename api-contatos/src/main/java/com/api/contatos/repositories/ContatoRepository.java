package com.api.contatos.repositories;

import com.api.contatos.entity.models.ContatoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoModel, UUID> {
    boolean existsByContato(String contato);
}
