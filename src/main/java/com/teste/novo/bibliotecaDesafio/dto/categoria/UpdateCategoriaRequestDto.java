package com.teste.novo.bibliotecaDesafio.dto.categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UpdateCategoriaRequestDto {

    @NotBlank
    @NotEmpty
    private String nome;

    public UpdateCategoriaRequestDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public UpdateCategoriaRequestDto() {
    }
}
