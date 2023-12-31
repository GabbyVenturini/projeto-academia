package com.api.cliente.services.v1;

import com.api.cliente.base.dto.BaseDto;
import com.api.cliente.base.dto.BaseResultDto;
import com.api.cliente.entity.models.ClienteModel;
import com.api.cliente.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.api.cliente.constants.MensagensErros.DADOS_NAO_ENCONTRADO;

@Service
public class BuscarClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public BaseDto<ClienteModel> buscarCliente(UUID id) {
        Optional<ClienteModel> clienteModel = clienteRepository.findById(id);
        if (clienteModel.isPresent()) {
            var baseResult = new BaseResultDto(HttpStatus.OK.value(), "Cliente escontrado.");
            var baseDto = new BaseDto<>(clienteModel.get());
            baseDto.setResultado(baseResult);
            return baseDto;
        } else {
            throw new RuntimeException(DADOS_NAO_ENCONTRADO);
        }
    }
}
