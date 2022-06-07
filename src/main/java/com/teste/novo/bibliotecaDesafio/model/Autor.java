package com.teste.novo.bibliotecaDesafio.model;

import com.teste.novo.bibliotecaDesafio.validator.VerificaEmailDuplicadoAutor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotEmpty
    private String nome;

    @Email
    @NotBlank
    @NotEmpty
    //@VerificaEmailDuplicadoAutor
    private String email;

    @NotBlank
    @NotEmpty
    @Size(max = 400)
    private String descricao;

    private OffsetDateTime dataCriacao = OffsetDateTime.now();

    public Autor(String nome, String email, String descricao, OffsetDateTime dataCriacao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Autor atualizaAutor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;

        return this;
    }

    public Autor() {
        super();
    }
}
