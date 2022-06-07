package com.teste.novo.bibliotecaDesafio.dto.pais;

import com.teste.novo.bibliotecaDesafio.model.Pais;

public class PaisResponseDto {

    private Long id;
    private String nome;

    public PaisResponseDto(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisResponseDto() {
    }
}
