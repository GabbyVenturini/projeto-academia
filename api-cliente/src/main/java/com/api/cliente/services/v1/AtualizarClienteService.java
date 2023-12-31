package com.api.cliente.services.v1;

import com.api.cliente.base.dto.BaseDto;
import com.api.cliente.base.dto.BaseErrorDto;
import com.api.cliente.builder.ResponseErrorBuilder;
import com.api.cliente.builder.ResponseSuccessBuilder;
import com.api.cliente.constants.MensagensErros;
import com.api.cliente.entity.dtos.ClienteAtualizarRequestDto;
import com.api.cliente.entity.dtos.ClienteResponseDto;
import com.api.cliente.entity.models.ClienteModel;
import com.api.cliente.repositories.ClienteRepository;
import com.api.cliente.transformer.ClienteModelTransform;
import com.api.cliente.validate.AtualizarClienteValidate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtualizarClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public AtualizarClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public BaseDto atualizarCliente(
            UUID idCliente,
            ClienteAtualizarRequestDto clienteAtualizarRequestDto) {

        List<BaseErrorDto> erros = new AtualizarClienteValidate().validate(clienteAtualizarRequestDto);
        ResponseErrorBuilder resultado = new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, erros);
        int contadorEmail = 0;
        int contadorSenhaCatraca = 0;

        if (!clienteRepository.existsById(idCliente)) {
            erros.add(new BaseErrorDto("Id Cliente.", MensagensErros.INEXISTENTE));
            return resultado.get().getBody();
        }

        Optional<ClienteModel> clienteExistente = clienteRepository.findById(idCliente);
        ClienteModel clienteModel = clienteExistente.get();

        if (clienteAtualizarRequestDto.getEmail() != null && !clienteAtualizarRequestDto.getEmail().isEmpty()) {
            if (clienteExistente.get().getEmail().equals(clienteAtualizarRequestDto.getEmail())) {
                erros.add(new BaseErrorDto("E-mail.", MensagensErros.CAMPO_DIFERENTE_ANTERIOR));
            } else if (clienteRepository.existsByEmail(clienteAtualizarRequestDto.getEmail()).orElse(false)) {
                erros.add(new BaseErrorDto("E-mail.", MensagensErros.DADO_JA_CADASTRADO));
            }
            contadorEmail = 1;
        }
        if (clienteAtualizarRequestDto.getSenhaCatraca() != null && !clienteAtualizarRequestDto.getSenhaCatraca().isEmpty()) {
            if (clienteExistente.get().getSenhaCatraca().equals(clienteAtualizarRequestDto.getSenhaCatraca())) {
                erros.add(new BaseErrorDto("Senha da catraca.", MensagensErros.CAMPO_DIFERENTE_ANTERIOR));
            }
            contadorSenhaCatraca = 1;
        }
        if (erros.size() > 0) {
            return resultado.get().getBody();
        }
        if (erros.size() > 0) {
            resultado = new ResponseErrorBuilder(HttpStatus.BAD_REQUEST, erros);
            return resultado.get().getBody();
        }
        clienteModel = new ClienteModelTransform().transformerAtualizarCliente(clienteAtualizarRequestDto, clienteModel);

        ClienteModel atualizarCliente = clienteRepository.save(clienteModel);

        ClienteResponseDto resposta = new ClienteResponseDto();
        if (contadorEmail == 1 || contadorSenhaCatraca ==1) {
            resposta = new ClienteResponseDto(
                    atualizarCliente.getNome().toString(),
                    contadorEmail == 1 ? atualizarCliente.getEmail().toString() : null,
                    contadorSenhaCatraca == 1 ? atualizarCliente.getSenhaCatraca().toString() : null
            );
        }
        return new ResponseSuccessBuilder<ClienteResponseDto>(
                HttpStatus.ACCEPTED,
                resposta,
                "Atualizado com sucesso.").get().getBody();

    }
}
