package com.squad.cadastro.repository.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="CLIENTE_INFORMACOES")
public class ClienteEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="documento")
    private String documento;

    @Column(name="tipo_pessoa")
    private String tipoPessoa;

    @Column(name="data_nascimento")
    private LocalDate dataNascimento;

    @Column(name="telefone")
    private String telefone;

    @Column(name="email")
    private String email;

    @Column(name="data_criacao")
    private LocalDateTime dataCadastro;

    @Column(name="data_atualizacao")
    private LocalDateTime dataAtualizacao;


    @OneToMany ( fetch = FetchType.LAZY)// Aqui determino a relação 1 cliente para muitos endereços
    private List<EnderecoEntity> endereco;


    public Long getId() {
        return id;
    }

    public List<EnderecoEntity> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<EnderecoEntity> endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }


}
