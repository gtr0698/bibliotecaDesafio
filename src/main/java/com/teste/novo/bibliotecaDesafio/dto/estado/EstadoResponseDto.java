package com.teste.novo.bibliotecaDesafio.dto.estado;

import com.teste.novo.bibliotecaDesafio.model.Estado;

public class EstadoResponseDto {

    private Long id;
    private String nome;

    public EstadoResponseDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public EstadoResponseDto() {
        super();
    }
}
