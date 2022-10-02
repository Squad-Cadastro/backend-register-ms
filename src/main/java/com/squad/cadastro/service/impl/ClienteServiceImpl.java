package com.squad.cadastro.service.impl;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.repository.ClienteRepository;
import com.squad.cadastro.repository.entity.ClienteEntity;
import com.squad.cadastro.service.ClienteService;
import com.squad.cadastro.validator.ValidatorInterface;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ClienteServiceImpl implements ClienteService {

    ValidatorInterface validator;

    ClienteRepository clienteRepository;

    public ClienteServiceImpl(ValidatorInterface validator, ClienteRepository clienteRepository) {
        this.validator = validator;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDto criarCliente(ClienteDto clienteDto) {
        final var clienteCriado = clienteRepository.save(convertToEntity(clienteDto));
        return convertToDto(clienteCriado);
    }

    private ClienteEntity convertToEntity(ClienteDto clienteDto) {
        ClienteEntity clienteEntity = new ClienteEntity();
        clienteEntity.setNome(clienteDto.getNome());
        clienteEntity.setEmail(clienteDto.getEmail());
        clienteEntity.setTipoPessoa(clienteDto.getTipoPessoa());
        clienteEntity.setDocumento(clienteDto.getDocumento());
        clienteEntity.setTelefone(clienteDto.getTelefone());
        clienteEntity.setDataNascimento(clienteDto.getDataNascimento());
        clienteEntity.setDataCadastro(LocalDateTime.now());
        return clienteEntity;
    }

    private ClienteDto convertToDto(ClienteEntity clienteCriado) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setId(clienteCriado.getId());
        clienteDto.setNome(clienteCriado.getNome());
        clienteDto.setDocumento(clienteCriado.getDocumento());
        clienteDto.setEmail(clienteCriado.getEmail());
        clienteDto.setTipoPessoa(clienteCriado.getTipoPessoa());
        clienteDto.setDataNascimento(clienteCriado.getDataNascimento());
        clienteDto.setTelefone(clienteCriado.getTelefone());
        clienteDto.setDataCadastro(clienteCriado.getDataCadastro());
        clienteDto.setDataAtualizacao(clienteCriado.getDataAtualizacao());
        return clienteDto;
    }
}
