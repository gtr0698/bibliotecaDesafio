package com.teste.novo.bibliotecaDesafio.dto.categoria;

import com.teste.novo.bibliotecaDesafio.model.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CreateCategoriaRequestDto {

    @NotBlank
    @NotEmpty
    private String nome;

    public CreateCategoriaRequestDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria convertToModel(){
        return new Categoria(nome);
    }

    public CreateCategoriaRequestDto() {
        super();
    }
}
