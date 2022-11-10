package com.squad.cadastro.controller.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ClienteDto implements Serializable {
    private Long id;
    private String nome;
    private String email;
    private String documento;
    private String tipoPessoa;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private LocalDateTime dataCadastro;

    private LocalDateTime dataAtualizacao;
    private List<EnderecoDto> endereco;

    public ClienteDto() {
    }

    public ClienteDto(Long id, String nome, String sobrenome, String documento, String tipoPessoa,
                      LocalDate dataNascimento, String telefone, String email, LocalDateTime dataCadastro,
                      LocalDateTime dataAtualizacao, List<EnderecoDto> endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.documento = documento;
        this.tipoPessoa = tipoPessoa;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<EnderecoDto> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoDto> endereco) {
        this.endereco = endereco;
    }
}
