package com.teste.novo.bibliotecaDesafio.dto.pais;

import com.teste.novo.bibliotecaDesafio.model.Pais;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CreatePaisRequestDto {

    @NotBlank
    @NotEmpty
    private String nome;

    public CreatePaisRequestDto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public CreatePaisRequestDto() {
        super();
    }

    public Pais convertToModel(){
        return new Pais(nome);
    }
}
