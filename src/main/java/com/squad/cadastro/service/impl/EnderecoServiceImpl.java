package com.squad.cadastro.service.impl;


import com.squad.cadastro.controller.dto.EnderecoDto;
import com.squad.cadastro.repository.RepositoryClienteEndereco;
import com.squad.cadastro.repository.entity.EnderecoEntity;
import com.squad.cadastro.service.EnderecoService;
import org.springframework.stereotype.Service;


@Service
public class EnderecoServiceImpl implements EnderecoService {

  RepositoryClienteEndereco enderecoRepository;

  @Override
  public EnderecoDto adicionarEndereco(EnderecoDto enderecoDto) {
    final var enderecoCriado = enderecoRepository.save(convertEnderecoToEntity(enderecoDto));
    return convertEnderecoToDto(enderecoCriado);
  }


  private EnderecoEntity convertEnderecoToEntity(EnderecoDto enderecoDto) {
    EnderecoEntity enderecoEntity = new EnderecoEntity();
    enderecoEntity.setLogradouro(enderecoDto.getLogradouro());
    enderecoEntity.setPrincipal(enderecoDto.getPrincipal());
    enderecoEntity.setNumero(enderecoDto.getNumero());
    enderecoEntity.setCep(enderecoDto.getCep());
    enderecoEntity.setBairro(enderecoDto.getBairro());
    enderecoEntity.setLocalidade(enderecoDto.getLocalidade());
    enderecoEntity.setUf(enderecoDto.getUf());
    return enderecoEntity;
  }

  private EnderecoDto convertEnderecoToDto(EnderecoEntity enderecoCriado) {
    EnderecoDto enderecoDto = new EnderecoDto();
    enderecoDto.setLogradouro(enderecoCriado.getLogradouro());
    enderecoDto.setPrincipal(enderecoCriado.getPrincipal());
    enderecoDto.setNumero(enderecoCriado.getNumero());
    enderecoDto.setCep(enderecoCriado.getCep());
    enderecoDto.setBairro(enderecoCriado.getBairro());
    enderecoDto.setLocalidade(enderecoCriado.getLocalidade());
    enderecoDto.setUf(enderecoCriado.getUf());
    return enderecoDto;
  }
}
