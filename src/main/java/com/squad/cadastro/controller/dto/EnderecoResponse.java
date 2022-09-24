package com.squad.cadastro.controller.dto;

import java.io.Serializable;

public class EnderecoResponse implements Serializable {

    private String cep;
    private String logradouro;
    private String uf;
    private String localidade;
    private String bairro;
    private String complemento;

    public EnderecoResponse() {
    }

    public EnderecoResponse(String cep, String logradouro, String uf, String localidade, String bairro, String complemento) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.uf = uf;
        this.localidade = localidade;
        this.bairro = bairro;
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
