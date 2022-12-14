package com.squad.cadastro.repository;

import com.squad.cadastro.repository.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

  ClienteEntity findByDocumento(String documento);
}
