package com.teste.novo.bibliotecaDesafio.repository;

import com.teste.novo.bibliotecaDesafio.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findByPaisId(Long pais);
}
