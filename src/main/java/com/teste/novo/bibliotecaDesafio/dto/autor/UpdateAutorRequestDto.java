package com.teste.novo.bibliotecaDesafio.dto.autor;

import com.teste.novo.bibliotecaDesafio.validator.VerificaEmailDuplicadoAutor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class UpdateAutorRequestDto {

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


    public UpdateAutorRequestDto(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
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

    public UpdateAutorRequestDto() {
    }
}
