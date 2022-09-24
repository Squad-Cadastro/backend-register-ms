package com.squad.cadastro.controller;
import serializable;

public class ControllerCadastro implements Serializable{

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public String getCep(String cep){
        return cep;
    }
    public void setCep(String cep){
        this.cep = cep;
    }
    public String getLogradouro(String logradouro){
        return logradouro;
    }
    public void setLogradouro(String logradouro){
        return logradouro;
    }
    public String getComplemento(String complemento){
        return complemento;
    }
    public void setComplemento(String complemento){
        return complemento;
    }
    public String getBairro(String bairro){
        return bairro;
    }
    public void setBairro(String bairro){
        return bairro;
    }
    public String getLocalidade(String localidade){
        return localidade;
    }
    public void setLocalidade(String localidade){
        return localidade;
    }
    public String getUf(String uf){
        return uf;
    }
    public void setUf(String uf){
        return uf;
    }
}
