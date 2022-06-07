package com.teste.novo.bibliotecaDesafio.repository;

import com.teste.novo.bibliotecaDesafio.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
