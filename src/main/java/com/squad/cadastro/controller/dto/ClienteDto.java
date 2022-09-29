package com.squad.cadastro.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class ClienteDto implements Serializable {
    private String id;
    private String nome;
    private String sobrenome;
    private String documento;
    private String tipoPessoa;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private LocalDate dataCadastro;
    private List<EnderecoDto> endereco;

    public ClienteDto(String id, String nome, String sobrenome, String documento, String tipoPessoa, LocalDate dataNascimento, String telefone, String email, LocalDate dataCadastro, List<EnderecoDto> endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.tipoPessoa = tipoPessoa;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
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

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public List<EnderecoDto> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoDto> endereco) {
        this.endereco = endereco;
    }
}
