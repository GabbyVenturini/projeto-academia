package com.api.contatos.services.v1;

import com.api.contatos.base.dtos.BaseDto;
import com.api.contatos.base.dtos.BaseErrorDto;
import com.api.contatos.entity.dto.ContatoRequestDto;
import com.api.contatos.entity.models.ContatoModel;
import com.api.contatos.repositories.ContatoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ContatoServiceTest {
    @InjectMocks
    private ContatoService service;
    @Mock
    private ContatoRepository repository;

    private ContatoModel model;
    private ContatoRequestDto requestDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarContato();
    }

    @Test
    void criarContatoSucesso(){
        when(repository.save(any(ContatoModel.class))).thenReturn(model);
        ResponseEntity<BaseDto> resultado= service.resgistrarContato(requestDto);
        assertNotNull(resultado);
        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }
    @Test
    void erroContatoExistente(){
        when(repository.existsByContato(any(String.class))).thenReturn(true);
        boolean existePorContato = repository.existsByContato(requestDto.getContato());
        ResponseEntity<BaseDto> resultado= service.resgistrarContato(requestDto);
        assertTrue(existePorContato);
        assertEquals(HttpStatus.CONFLICT,resultado.getStatusCode());
    }

    private void iniciarContato(){
        model = new ContatoModel();
        model.setId(UUID.randomUUID());
        requestDto = new ContatoRequestDto();
        requestDto.setIdFuncionario(UUID.randomUUID());
        requestDto.setContato("71980203040");
        requestDto.setStatus(1);


    }
}