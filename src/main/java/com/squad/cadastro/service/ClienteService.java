package com.squad.cadastro.service;

import com.squad.cadastro.controller.dto.ClienteDto;

import java.util.List;

public interface ClienteService {
    ClienteDto criarCliente(ClienteDto cliente) throws Exception;

    List<ClienteDto> getAll();

    ClienteDto findByDocumento(String documento);

    ClienteDto findById(Long id);
}
