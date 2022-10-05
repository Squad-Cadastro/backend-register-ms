package com.squad.cadastro.service.impl;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.repository.ClienteRepository;
import com.squad.cadastro.repository.entity.ClienteEntity;
import com.squad.cadastro.service.ClienteService;
import com.squad.cadastro.validator.ValidatorInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class ClienteServiceImpl implements ClienteService {

    ValidatorInterface validator;

    @Autowired
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

    //Método para pegar todos os clientes
    public ClienteDto getAll() {
        return (ClienteDto) clienteRepository.findAll();
    }


    //Rota par abusca por documento
    @Autowired
    ClienteDto clienteDto;
    public ClienteEntity getByDocumento(@PathVariable String documento){
        String doc = clienteDto.getDocumento();
        ClienteEntity clientePorDocumento = clienteRepository.findById(doc);
        if (!clientePorDocumento) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return clientePorDocumento;
    }
   }
