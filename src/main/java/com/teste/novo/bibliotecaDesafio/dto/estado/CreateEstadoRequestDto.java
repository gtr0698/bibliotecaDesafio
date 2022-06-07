package com.teste.novo.bibliotecaDesafio.dto.estado;

import com.teste.novo.bibliotecaDesafio.model.Estado;
import com.teste.novo.bibliotecaDesafio.model.Pais;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CreateEstadoRequestDto {

    @NotBlank
    @NotEmpty
    private String nome;

    private Pais pais;

    public CreateEstadoRequestDto(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado convertToModel(Pais pais){
        return new Estado(nome, pais);
    }

    public CreateEstadoRequestDto() {
        super();
    }
}
