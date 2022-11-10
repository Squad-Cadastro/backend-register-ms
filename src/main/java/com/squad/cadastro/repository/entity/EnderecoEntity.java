package com.squad.cadastro.repository.entity;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Entity
@Table(name="CLIENTE_ENDERECO")
public class EnderecoEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column(name="cep")
  private String cep;
  @Column(name="logradouro")
  private String logradouro;
  @Column(name="principal")
  private String principal;
  @Column(name="numero")
  private String numero;
  @Column(name="bairro")
  private String bairro;
  @Column(name="localidade")
  private String localidade;
  @Column(name="uf")
  private String uf;

  public EnderecoEntity() {
  }


  public EnderecoEntity(Long id, String logradouro, String principal, String numero, String cep, String bairro, String localidade, String uf) {
    this.id = id;
    this.logradouro = logradouro;
    this.principal = principal;
    this.numero = numero;
    this.cep = cep;
    this.bairro = bairro;
    this.localidade = localidade;
    this.uf = uf;
  }

  public Long getEnderecoId() {
    return id;
  }

  public void setEnderecoId(Long id) {
    this.id = id;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getPrincipal() {
    return principal;
  }

  public void setPrincipal(String principal) {
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
