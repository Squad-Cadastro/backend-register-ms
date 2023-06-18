package com.squad.cadastro.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="cliente_informacoes")
public class ClienteEntity implements Serializable {

    @Serial
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

    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "clienteInformacoes")
    private List<EnderecoEntity> endereco;
}
