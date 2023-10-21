package com.api.plano.services.v1;

import com.api.plano.base.dto.BaseDto;
import com.api.plano.entities.dtos.PlanoRequestDto;
import com.api.plano.entities.dtos.PlanoResponseDto;
import com.api.plano.entities.enums.PlanosEnum;
import com.api.plano.entities.models.PlanoModel;
import com.api.plano.repositories.PlanoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("PlanoService - testes")
    public class PlanoServiceTest {

    @MockBean
    private PlanoRepository planoRepository;

    @Autowired
    private PlanoService planoService;
    private PlanoRequestDto dtoPlano;
    private PlanoModel plano;

    @BeforeEach
    public void setUp(){
        planoRepository = mock(PlanoRepository.class);
        planoService = new PlanoService(planoRepository);

        dtoPlano = new PlanoRequestDto();
        dtoPlano.setNome(PlanosEnum.valueOf("BASICO"));
        dtoPlano.setDescricao("area de musculacao e aerobicos");
        dtoPlano.setValor(100.00);
        dtoPlano.setValorPromocional(89.90);
        dtoPlano.setStatus(1);

        PlanoModel plano = new PlanoModel();
    }
//********************************************************************************************************************//
    @Test
    @DisplayName("01 - service - criar Nome válido")
    public void testCriarNomeValido() {
        PlanoRequestDto novoPlanoDto = new PlanoRequestDto();
        novoPlanoDto.setNome(PlanosEnum.valueOf("BASICO"));
        novoPlanoDto.setDescricao("Plano básico");
        novoPlanoDto.setValor(50.0);
        novoPlanoDto.setValorPromocional(40.0);

        Mockito.when(planoRepository.existsByNome(PlanosEnum.valueOf("BASICO"))).thenReturn(Optional.empty());

        PlanoModel novoPlano = new PlanoModel();
        UUID novoPlanoId = UUID.randomUUID();
        novoPlano.setId(novoPlanoId);
        Mockito.when(planoRepository.save(Mockito.any(PlanoModel.class))).thenReturn(novoPlano);

        ResponseEntity response = planoService.criarPlano(novoPlanoDto);

        assert response.getStatusCodeValue() == 201;
    }
//********************************************************************************************************************//
@Test
@DisplayName("02 - Service - Teste Enums")
@ParameterizedTest
@ValueSource(strings = {"BASICO", "ESSENCIAL", "OURO", "FUNCIONARIO"})
public void testarEnums(String nomePlano) {
    UUID validUUID = UUID.randomUUID();

    PlanoModel plano = new PlanoModel();
    plano.setId(validUUID);

    dtoPlano.setNome(PlanosEnum.valueOf(nomePlano));

    when(planoRepository.existsByNome(any(PlanosEnum.class))).thenReturn(
            Optional.of(false));

    when(planoRepository.save(any(PlanoModel.class))).thenReturn(plano);

    BaseDto<PlanoResponseDto> responseEntity = (BaseDto<PlanoResponseDto>)
            planoService.criarPlano(dtoPlano).getBody();

    assertEquals(HttpStatus.CREATED.value(), responseEntity.getResultado().getStatus());
    assertEquals("Plano criado com sucesso!",
            responseEntity.getResultado().getDescricao());
}
//********************************************************************************************************************//
    @Test
    @DisplayName("03 - service - criar Descrição Inválido")
    public void testCriarDescricaoValido() {
        PlanoRequestDto novoPlanoDto = new PlanoRequestDto();
        novoPlanoDto.setNome(PlanosEnum.valueOf("BASICO"));
        novoPlanoDto.setDescricao("");
        novoPlanoDto.setValor(50.0);
        novoPlanoDto.setValorPromocional(40.0);

        Mockito.when(planoRepository.existsByNome(PlanosEnum.valueOf("BASICO"))).thenReturn(Optional.empty());

        PlanoModel novoPlano = new PlanoModel();
        UUID novoPlanoId = UUID.randomUUID();
        novoPlano.setId(novoPlanoId);
        Mockito.when(planoRepository.save(Mockito.any(PlanoModel.class))).thenReturn(novoPlano);

        ResponseEntity response = planoService.criarPlano(novoPlanoDto);

        assert response.getStatusCodeValue() == 400;
    }
//********************************************************************************************************************//
@Test
@DisplayName("04 - service - Valor não pode ser igual Valor Promocional")
public void testCriarValoresIguais() {
    PlanoRequestDto novoPlanoDto = new PlanoRequestDto();
    novoPlanoDto.setNome(PlanosEnum.valueOf("BASICO"));
    novoPlanoDto.setDescricao("Plano básico");
    novoPlanoDto.setValor(50.0);
    novoPlanoDto.setValorPromocional(50.0);

    Mockito.when(planoRepository.existsByNome(PlanosEnum.valueOf("BASICO"))).thenReturn(Optional.empty());

    PlanoModel novoPlano = new PlanoModel();
    UUID novoPlanoId = UUID.randomUUID();
    novoPlano.setId(novoPlanoId);
    Mockito.when(planoRepository.save(Mockito.any(PlanoModel.class))).thenReturn(novoPlano);

    ResponseEntity response = planoService.criarPlano(novoPlanoDto);

    assert response.getStatusCodeValue() == 400;
    }
//********************************************************************************************************************//
    @Test
    @DisplayName("05 - service - Valor não pode ser menor do que Valor Promocional")
    public void testCriarValorPromocionalMaiorValor() {
        PlanoRequestDto novoPlanoDto = new PlanoRequestDto();
        novoPlanoDto.setNome(PlanosEnum.valueOf("BASICO"));
        novoPlanoDto.setDescricao("Plano básico");
        novoPlanoDto.setValor(50.0);
        novoPlanoDto.setValorPromocional(60.0);

        Mockito.when(planoRepository.existsByNome(PlanosEnum.valueOf("BASICO"))).thenReturn(Optional.empty());

        PlanoModel novoPlano = new PlanoModel();
        UUID novoPlanoId = UUID.randomUUID();
        novoPlano.setId(novoPlanoId);
        Mockito.when(planoRepository.save(Mockito.any(PlanoModel.class))).thenReturn(novoPlano);

        ResponseEntity response = planoService.criarPlano(novoPlanoDto);

        assert response.getStatusCodeValue() == 400;
    }
//********************************************************************************************************************//
@Test
@DisplayName("06 - service - Valor Promocional não pode ser zero")
public void testCriarValorPromocionalZero() {
    PlanoRequestDto novoPlanoDto = new PlanoRequestDto();
    novoPlanoDto.setNome(PlanosEnum.valueOf("BASICO"));
    novoPlanoDto.setDescricao("Plano básico");
    novoPlanoDto.setValor(50.0);
    novoPlanoDto.setValorPromocional(0.0);

    Mockito.when(planoRepository.existsByNome(PlanosEnum.valueOf("BASICO"))).thenReturn(Optional.empty());

    PlanoModel novoPlano = new PlanoModel();
    UUID novoPlanoId = UUID.randomUUID();
    novoPlano.setId(novoPlanoId);
    Mockito.when(planoRepository.save(Mockito.any(PlanoModel.class))).thenReturn(novoPlano);

    ResponseEntity response = planoService.criarPlano(novoPlanoDto);

    assert response.getStatusCodeValue() == 400;
    }
//********************************************************************************************************************//
@Test
@DisplayName("07 - service - Valor não pode ser zero")
public void testCriarValorZero() {
    PlanoRequestDto novoPlanoDto = new PlanoRequestDto();
    novoPlanoDto.setNome(PlanosEnum.valueOf("BASICO"));
    novoPlanoDto.setDescricao("Plano básico");
    novoPlanoDto.setValor(0.0);
    novoPlanoDto.setValorPromocional(50.0);

    Mockito.when(planoRepository.existsByNome(PlanosEnum.valueOf("BASICO"))).thenReturn(Optional.empty());

    PlanoModel novoPlano = new PlanoModel();
    UUID novoPlanoId = UUID.randomUUID();
    novoPlano.setId(novoPlanoId);
    Mockito.when(planoRepository.save(Mockito.any(PlanoModel.class))).thenReturn(novoPlano);

    ResponseEntity response = planoService.criarPlano(novoPlanoDto);

    assert response.getStatusCodeValue() == 400;
    }
}