package com.squad.cadastro.service;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.repository.entity.ClienteEntity;

import java.util.List;

public interface ClienteService {
    ClienteDto criarCliente(ClienteDto cliente);

    List<ClienteDto> getAll();

    ClienteEntity findByDocumento(String documento);
}
