package com.teste.novo.bibliotecaDesafio.dto.autor;

import com.teste.novo.bibliotecaDesafio.model.Autor;
import com.teste.novo.bibliotecaDesafio.validator.VerificaEmailDuplicadoAutor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class CreateAutorRequestDto {

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

    private OffsetDateTime dataCriacao;


    public CreateAutorRequestDto(String nome, String email, String descricao, OffsetDateTime dataCriacao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
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

    public CreateAutorRequestDto() {
        super();
    }

    public Autor converToModel() {
        return new Autor(nome, email, descricao, dataCriacao);
    }
}
