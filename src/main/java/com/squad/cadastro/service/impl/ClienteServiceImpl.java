package com.squad.cadastro.service.impl;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.service.ClienteService;
import com.squad.cadastro.validator.ValidatorInterface;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteServiceImpl implements ClienteService {

    ValidatorInterface validator;

    public ClienteServiceImpl(ValidatorInterface validator) {
        this.validator = validator;
    }

    @Override
    public ClienteDto criarCliente(ClienteDto cliente) {
        cliente.setId(String.valueOf(UUID.randomUUID()));
        return cliente;
    }
}
