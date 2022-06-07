package com.teste.novo.bibliotecaDesafio.dto.livro;

import com.teste.novo.bibliotecaDesafio.model.Autor;
import com.teste.novo.bibliotecaDesafio.model.Categoria;
import com.teste.novo.bibliotecaDesafio.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroResponseDto {

    private Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numeroPaginas;
    private String isbn;
    private LocalDate publicacao;
    private Categoria categoria;
    private Autor autor;

    public LivroResponseDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.isbn = livro.getIsbn();
        this.publicacao = livro.getPublicacao();
        this.categoria = livro.getCategoria();
        this.autor = livro.getAutor();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicacao() {
        return publicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public LivroResponseDto() {
    }
}
