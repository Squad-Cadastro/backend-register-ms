package com.squad.cadastro.repository;

import com.squad.cadastro.repository.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClienteEndereco extends JpaRepository<EnderecoEntity, Long> {

}
