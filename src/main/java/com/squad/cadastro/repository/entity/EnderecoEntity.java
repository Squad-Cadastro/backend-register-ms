package com.squad.cadastro.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="cliente_endereco")
public class EnderecoEntity implements Serializable {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(name="cep")
  private String cep;
  @Column(name="logradouro")
  private String logradouro;
  @Column(name="principal")
  private boolean principal;
  @Column(name="numero")
  private String numero;
  @Column(name="bairro")
  private String bairro;
  @Column(name="localidade")
  private String localidade;
  @Column(name="uf")
  private String uf;

  @ManyToOne(fetch = FetchType.LAZY)
  private ClienteEntity clienteInformacoes;

}
