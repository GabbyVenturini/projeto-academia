package com.api.funcionario.services.v1;

import com.api.funcionario.base.dtos.BaseDto;
import com.api.funcionario.entity.dto.FuncionarioRequestDto;
import com.api.funcionario.entity.model.FuncionarioModel;
import com.api.funcionario.repository.FuncionarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class FuncionarioServiceTest {
    @InjectMocks
    private FuncionarioService service;
    @Mock
    private FuncionarioRepository repository;

    private FuncionarioModel model;
    private FuncionarioRequestDto requestDto;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        iniciarFuncionario();

    }

    @Test
    void criarFuncionarioSucesso(){
        when(repository.existsByEmail(any(String.class))).thenReturn(false);
        when(repository.existsByCpf(any(String.class))).thenReturn(false);
        when(repository.save(any(FuncionarioModel.class))).thenReturn(model);
        boolean existePorEmail = repository.existsByEmail(requestDto.getEmail());
        boolean existePorCpf = repository.existsByCpf(requestDto.getCpf());
        ResponseEntity<BaseDto> resultado= service.resgistrarFuncionario(requestDto);
        assertFalse(existePorEmail);
        assertFalse(existePorCpf);
        assertNotNull(resultado);
        assertEquals(HttpStatus.CREATED, resultado.getStatusCode());
    }
    @Test
    void falhaFuncionarioExistente(){
        when(repository.existsByEmail(any(String.class))).thenReturn(true);
        when(repository.existsByCpf(any(String.class))).thenReturn(true);
        boolean existePorEmail = repository.existsByEmail(requestDto.getEmail());
        boolean existePorCpf = repository.existsByCpf(requestDto.getCpf());
        ResponseEntity<BaseDto> resultado= service.resgistrarFuncionario(requestDto);
        assertTrue(existePorEmail);
        assertTrue(existePorCpf);
        assertEquals(HttpStatus.CONFLICT,resultado.getStatusCode());
    }


    private void iniciarFuncionario(){
        model = new FuncionarioModel();
        model.setId(UUID.randomUUID());
        requestDto = new FuncionarioRequestDto();
        requestDto.setCpf("123.123.123-12");
        requestDto.setDataNascimento("1970-02-02");
        requestDto.setEmail("teste@gmail.com");
        requestDto.setNome("Italo Alisson");
        requestDto.setPermissao("visitante");
        requestDto.setStatus(1);

    }


}