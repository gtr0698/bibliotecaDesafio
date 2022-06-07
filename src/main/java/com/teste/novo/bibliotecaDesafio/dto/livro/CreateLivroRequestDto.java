package com.teste.novo.bibliotecaDesafio.dto.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.novo.bibliotecaDesafio.model.Autor;
import com.teste.novo.bibliotecaDesafio.model.Categoria;
import com.teste.novo.bibliotecaDesafio.model.Livro;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateLivroRequestDto {

    @NotBlank
    @NotEmpty
    private String titulo;

    @NotBlank
    @NotEmpty
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @NotNull
    @Min(20)
    private BigDecimal preco;

    @NotNull
    @Min(20)
    private Integer numeroPaginas;

    @NotNull
    @NotBlank
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate publicacao;

    @NotNull
    private Categoria categoria;

    @NotNull
    private Autor autor;

    public CreateLivroRequestDto(String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas,
                                 String isbn, LocalDate publicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoria = categoria;
        this.autor = autor;
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

    public Livro convertToModel(){
        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, publicacao, categoria, autor);
    }

    public CreateLivroRequestDto() {
        super();
    }
}
