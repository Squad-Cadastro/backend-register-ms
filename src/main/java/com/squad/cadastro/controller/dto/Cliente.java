package com.squad.cadastro.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente implements Serializable {
    private String id;
    private String nome;
    private String sobrenome;
    private String documento;
    private String tipo_pessoa;
    private LocalDate data_nascimento;
    private String telefone;
    private String email;
    private LocalDate dataCadastro;
    private String[] endereco;
    private String logradouro;
    private String principal;
    private String numero;
    private String cep;
    private String bairro;
    private String localidade;
    private String uf;





    public Cliente(String id, String nome, String sobrenome, String documento,
        String tipo_pessoa, LocalDate data_nascimento, String telefone, String email,
        LocalDate dataCadastro, String[] endereco, String logradouro, String principal,
        String numero, String cep, String bairro, String localidade, String uf )
    {

        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.tipo_pessoa = tipo_pessoa;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
        this.logradouro = logradouro;
        this.principal = principal;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
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

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
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

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String[] getEndereco() {
        return endereco;
    }

    public void setEndereco(String[] endereco) {
        this.endereco = endereco;
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
