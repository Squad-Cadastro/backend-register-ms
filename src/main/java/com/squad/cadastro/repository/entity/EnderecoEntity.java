package com.squad.cadastro.repository.entity;


import javax.persistence.*;
import java.io.Serializable;

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

  public EnderecoEntity() {
  }


  public EnderecoEntity(Long id, String logradouro, boolean principal, String numero, String cep, String bairro,
                        String localidade, String uf, ClienteEntity clienteInformacoes) {
    this.id = id;
    this.logradouro = logradouro;
    this.principal = principal;
    this.numero = numero;
    this.cep = cep;
    this.bairro = bairro;
    this.localidade = localidade;
    this.uf = uf;
    this.clienteInformacoes = clienteInformacoes;
  }

  public ClienteEntity getClienteInformacoes() {
    return clienteInformacoes;
  }

  public void setClienteInformacoes(ClienteEntity clienteInformacoes) {
    this.clienteInformacoes = clienteInformacoes;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public boolean isPrincipal() {
    return principal;
  }

  public void setPrincipal(boolean principal) {
    this.principal = principal;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }
}
