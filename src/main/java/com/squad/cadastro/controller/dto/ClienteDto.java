package com.squad.cadastro.controller.dto;

import java.io.Serializable;

public class ClienteDto implements Serializable {
    private String id;
    private String nome;
    private String email;
    private String documento;
    private String telefone;
    private String data;


    public ClienteDto(String id, String nome, String email, String documento, String telefone,String data) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.telefone = telefone;
        this.data = data;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getDocumento() {

        return documento;
    }
    public void setDocumento(String documento) {

        this.documento = documento;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
