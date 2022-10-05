package com.squad.cadastro.service;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.repository.entity.ClienteEntity;
import org.springframework.data.domain.Page;

public interface ClienteService {
    ClienteDto criarCliente(ClienteDto cliente);

    ClienteDto getAll();
}
