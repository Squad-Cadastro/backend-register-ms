package com.squad.cadastro.service.impl;

import com.squad.cadastro.config.Mapping;
import com.squad.cadastro.controller.dto.ClienteDto;
import com.squad.cadastro.repository.ClienteRepository;
import com.squad.cadastro.repository.entity.ClienteEntity;
import com.squad.cadastro.service.ClienteService;
import com.squad.cadastro.validator.ValidatorInterface;
import com.squad.cadastro.validator.ValidatorTelefone;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.util.List;

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

    public ClienteDto criarCliente(ClienteDto clienteDto) throws Exception {
      validarDadosCliente(clienteDto);
      final var clienteCriado = clienteRepository.save(Mapping.parseObject(clienteDto, ClienteEntity.class));
      return Mapping.parseObject(clienteCriado, ClienteDto.class);
    }

    public List<ClienteDto> getAllClientes() {
      return Mapping.parseListObjects(clienteRepository.findAll(), ClienteDto.class);
    }

    public ClienteDto findByDocumento(String documento) {
      final var clientePorDocumento = clienteRepository.findByDocumento(documento);
      if (clientePorDocumento == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      return Mapping.parseObject(clientePorDocumento, ClienteDto.class);
    }

    public ClienteDto findById(Long id) {
      final var clienteEntity = clienteRepository.findById(id);
      if (clienteEntity.isPresent()) {
        return Mapping.parseObject(clienteEntity.get(), ClienteDto.class);
      } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
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
}