package com.teste.novo.bibliotecaDesafio.service;

import com.teste.novo.bibliotecaDesafio.dto.categoria.CreateCategoriaRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.categoria.UpdateCategoriaRequestDto;
import com.teste.novo.bibliotecaDesafio.exception.RegraException;
import com.teste.novo.bibliotecaDesafio.model.Categoria;
import com.teste.novo.bibliotecaDesafio.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvar(CreateCategoriaRequestDto categoria){

        Categoria categoriaNova = categoria.convertToModel();

        return categoriaRepository.save(categoriaNova);
    }

    public Page<Categoria> listar(Pageable pageable){
        return categoriaRepository.findAll(pageable);
    }

    public Categoria buscar(Long categoriaId){
        Categoria categoria = verificaExistente(categoriaId);

        return categoria;
    }

    public Categoria verificaExistente(Long categoriaId) {
        Optional<Categoria> categoriaExistente = categoriaRepository.findById(categoriaId);

        if(categoriaExistente.isEmpty()){
            throw new RegraException("categoria não localizada!");
        }

        return categoriaExistente.get();
    }

    public Categoria atualizar(Long categoriaId, UpdateCategoriaRequestDto request){
        Categoria categoria = verificaExistente(categoriaId);
        Categoria categoriaAtualizada = categoria.atualizaCategoria(request.getNome());

        return categoriaRepository.save(categoriaAtualizada);
    }

    public void excluir(Long categoriaId){

        Categoria categoria = verificaExistente(categoriaId);

        categoriaRepository.deleteById(categoriaId);
    }

}
