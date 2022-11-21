package com.squad.cadastro.service.impl;

import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.controller.dto.EnderecoDto;
import com.squad.cadastro.repository.ClienteRepository;
import com.squad.cadastro.repository.entity.ClienteEntity;
import com.squad.cadastro.repository.entity.EnderecoEntity;
import com.squad.cadastro.service.ClienteService;
import com.squad.cadastro.validator.ValidatorInterface;
import com.squad.cadastro.validator.ValidatorTelefone;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    ValidatorInterface validator;
    ValidatorTelefone validatorTelefone;
    static final String LINE_SEPARATOR = "line.separator";
    ClienteRepository clienteRepository;

    public ClienteServiceImpl(ValidatorInterface validator, ValidatorTelefone validatorTelefone, ClienteRepository clienteRepository) {
        this.validator = validator;
        this.validatorTelefone = validatorTelefone;
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDto criarCliente(ClienteDto clienteDto) throws Exception {
        validarDadosCliente(clienteDto);
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
    var enderecoEntity = clienteDto.getEndereco()
        .stream()
        .map(this::convertEnderecoToEntity)
        .collect(Collectors.toList());
    enderecoEntity.forEach(endereco -> endereco.setClienteInformacoes(clienteEntity));
    clienteEntity.setEndereco(enderecoEntity);
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
    var enderecoDto = clienteCriado.getEndereco()
        .stream()
        .map(this :: convertEnderecoToDto)
        .collect(Collectors.toList());
    clienteDto.setEndereco(enderecoDto);
    return clienteDto;
  }

    private void validarDadosCliente(ClienteDto cliente) throws Exception {
        var errorMessage = new StringBuilder();
        if (this.validator.validarEmail(cliente.getEmail())) {
            errorMessage.append(MessageFormat.format("Email {0} invalido. {1}",
                    cliente.getEmail(), System.getProperty(LINE_SEPARATOR)));
        }
        if (!this.validatorTelefone.validarTelefone(cliente.getTelefone())) {
            errorMessage.append(MessageFormat.format("Telefone {0} invalido. {1}",
                    cliente.getTelefone(), System.getProperty(LINE_SEPARATOR)));
        }
        if (!this.validator.validarCPF(cliente.getDocumento())) {
            errorMessage.append(MessageFormat.format("Documento {0} invalido. {1}",
                    cliente.getDocumento(), System.getProperty(LINE_SEPARATOR)));
        }
        if(this.validator.validarData(cliente.getDataNascimento())){
            errorMessage.append(MessageFormat.format("Idade inferior a 18 anos {0}", System.getProperty(LINE_SEPARATOR)));
        }
        if (!errorMessage.toString().isBlank()){
            throw new Exception(errorMessage.toString());
        }
    }
//Converters de endereço
private EnderecoEntity convertEnderecoToEntity(EnderecoDto enderecoDto) {
  EnderecoEntity enderecoEntity = new EnderecoEntity();
  enderecoEntity.setId(enderecoDto.getId());
  enderecoEntity.setLogradouro(enderecoDto.getLogradouro());
  enderecoEntity.setPrincipal(enderecoDto.isPrincipal());
  enderecoEntity.setNumero(enderecoDto.getNumero());
  enderecoEntity.setCep(enderecoDto.getCep());
  enderecoEntity.setBairro(enderecoDto.getBairro());
  enderecoEntity.setLocalidade(enderecoDto.getLocalidade());
  enderecoEntity.setUf(enderecoDto.getUf());
  return enderecoEntity;
}

  private EnderecoDto convertEnderecoToDto(EnderecoEntity enderecoCriado) {
    EnderecoDto enderecoDto = new EnderecoDto();
    enderecoDto.setId(enderecoCriado.getId());
    enderecoDto.setLogradouro(enderecoCriado.getLogradouro());
    enderecoDto.setPrincipal(enderecoCriado.isPrincipal());
    enderecoDto.setNumero(enderecoCriado.getNumero());
    enderecoDto.setCep(enderecoCriado.getCep());
    enderecoDto.setBairro(enderecoCriado.getBairro());
    enderecoDto.setLocalidade(enderecoCriado.getLocalidade());
    enderecoDto.setUf(enderecoCriado.getUf());
    return enderecoDto;
  }
}
