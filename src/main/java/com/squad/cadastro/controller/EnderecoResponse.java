package com.squad.cadastro.controller;
import java.io.Serializable;


public class EnderecoResponse implements Serializable{

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    public EnderecoResponse(String cep, String logradouro, String uf, String localidade, String bairro, String complemento) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.uf = uf;
        this.localidade = localidade;
        this.bairro = bairro;
        this.complemento = complemento;
    }

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
        this.logradouro = logradouro;
    }
    public String getComplemento(String complemento){
        return complemento;
    }
    public void setComplemento(String complemento)
    {
        this.complemento = complemento;
    }
    public String getBairro(String bairro){
        return bairro;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public String getLocalidade(String localidade){
        return localidade;
    }
    public void setLocalidade(String localidade){
        this.localidade = localidade;
    }
    public String getUf(String uf){
        return uf;
    }
    public void setUf(String uf){
        this.uf = uf;
    }

}
