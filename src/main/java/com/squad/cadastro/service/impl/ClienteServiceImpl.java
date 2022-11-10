package com.squad.cadastro.service.impl;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.controller.dto.EnderecoDto;
import com.squad.cadastro.repository.ClienteRepository;
import com.squad.cadastro.repository.RepositoryClienteEndereco;
import com.squad.cadastro.repository.entity.ClienteEntity;
import com.squad.cadastro.repository.entity.EnderecoEntity;
import com.squad.cadastro.service.ClienteService;
import com.squad.cadastro.validator.ValidatorInterface;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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


  //Método para pegar todos os clientes
  @Override
  public List<ClienteDto> getAllClientes() {
    return clienteRepository.findAll()
        .stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
  }

  @Override
  public ClienteDto findByDocumento(String documento) {
    final var clientePorDocumento = clienteRepository.findByDocumento(documento);
    if (clientePorDocumento == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    return convertToDto(clientePorDocumento);
  }

  @Override
  public ClienteDto findById(Long id) {
    final var clienteEntity = clienteRepository.findById(id);
    if (clienteEntity.isPresent()) {
      return convertToDto(clienteEntity.get());
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
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
