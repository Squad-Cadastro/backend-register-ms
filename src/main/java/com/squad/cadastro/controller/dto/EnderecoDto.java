package com.squad.cadastro.controller.dto;

import java.io.Serializable;

public class EnderecoDto implements Serializable {
    private String logradouro;
    private String principal;
    private String numero;
    private String cep;
    private String bairro;
    private String localidade;
    private String uf;

    public EnderecoDto(String logradouro, String principal, String numero, String cep,
                       String bairro, String localidade, String uf) {
        this.logradouro = logradouro;
        this.principal = principal;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
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
