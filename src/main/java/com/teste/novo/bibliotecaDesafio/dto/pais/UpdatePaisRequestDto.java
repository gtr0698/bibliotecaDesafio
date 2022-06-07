package com.teste.novo.bibliotecaDesafio.dto.pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UpdatePaisRequestDto {

    @NotBlank
    @NotEmpty
    private String nome;

    public UpdatePaisRequestDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public UpdatePaisRequestDto() {
    }
}
