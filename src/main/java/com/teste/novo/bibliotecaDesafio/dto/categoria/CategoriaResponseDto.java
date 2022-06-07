package com.teste.novo.bibliotecaDesafio.dto.categoria;

import com.teste.novo.bibliotecaDesafio.model.Categoria;

public class CategoriaResponseDto {

    private Long id;
    private String nome;

    public CategoriaResponseDto(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CategoriaResponseDto() {
    }
}
