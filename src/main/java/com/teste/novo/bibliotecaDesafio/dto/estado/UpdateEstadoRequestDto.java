package com.teste.novo.bibliotecaDesafio.dto.estado;

import com.teste.novo.bibliotecaDesafio.model.Pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UpdateEstadoRequestDto {

    @NotBlank
    @NotEmpty
    private String nome;

    private Pais pais;

    public UpdateEstadoRequestDto(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public UpdateEstadoRequestDto() {
    }
}
