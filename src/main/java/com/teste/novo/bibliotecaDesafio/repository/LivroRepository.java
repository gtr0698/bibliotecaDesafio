package com.teste.novo.bibliotecaDesafio.repository;

import com.teste.novo.bibliotecaDesafio.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
