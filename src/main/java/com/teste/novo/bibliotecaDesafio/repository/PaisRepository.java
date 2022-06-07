package com.teste.novo.bibliotecaDesafio.repository;

import com.teste.novo.bibliotecaDesafio.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {
}
