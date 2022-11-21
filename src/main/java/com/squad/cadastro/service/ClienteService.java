package com.squad.cadastro.service;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.controller.dto.EnderecoDto;

import java.util.List;

public interface ClienteService {
    ClienteDto criarCliente(ClienteDto cliente) throws Exception;

    List<ClienteDto> getAllClientes();

    ClienteDto findByDocumento(String documento);

    ClienteDto findById(Long id);
}
