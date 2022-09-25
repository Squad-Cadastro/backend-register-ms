package com.squad.cadastro.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente implements Serializable {
    private String id;
    private String nome;
    private String sobrenome;
    private String documento;
    private String tipo_pessoa;
    private LocalDate data_nascimanto;
    private String telefone;
    private String email;

    public Cliente(String id, String nome, String sobrenome, String documento,
                   String tipo_pessoa, LocalDate data_nascimanto, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.tipo_pessoa = tipo_pessoa;
        this.data_nascimanto = data_nascimanto;
        this.telefone = telefone;
        this.email = email;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTipo_pessoa() {
        return tipo_pessoa;
    }

    public void setTipo_pessoa(String tipo_pessoa) {
        this.tipo_pessoa = tipo_pessoa;
    }

    public LocalDate getData_nascimanto() {
        return data_nascimanto;
    }

    public void setData_nascimanto(LocalDate data_nascimanto) {
        this.data_nascimanto = data_nascimanto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
