package com.teste.novo.bibliotecaDesafio.service;

import com.teste.novo.bibliotecaDesafio.dto.livro.CreateLivroRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.livro.UpdateLivroRequestDto;
import com.teste.novo.bibliotecaDesafio.exception.RegraException;
import com.teste.novo.bibliotecaDesafio.model.Livro;
import com.teste.novo.bibliotecaDesafio.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;


    public Livro salvar(CreateLivroRequestDto livro){

        Livro novoLivro = livro.convertToModel();

        return livroRepository.save(novoLivro);
    }

    public Page<Livro> listar(Pageable pageable){
        return livroRepository.findAll(pageable);
    }

    public Livro buscar(Long livroId){
        Livro livro = verificaExistencia(livroId);

        return livro;
    }

    public Livro verificaExistencia(Long livroId) {
        Optional<Livro> livroExistente = livroRepository.findById(livroId);

        if(livroExistente.isEmpty()){
            throw new RegraException("Livro não localizado!");
        }

        return livroExistente.get();
    }

    public Livro atualizar(Long livroId, UpdateLivroRequestDto request){
        Livro livro = verificaExistencia(livroId);
        Livro atualizarLivro = livro.atualizaLivro(request.getTitulo(), request.getResumo(), request.getSumario(),
                request.getPreco(), request.getNumeroPaginas(), request.getIsbn(), request.getPublicacao(),
                request.getCategoria(),request.getAutor());

        return livroRepository.save(atualizarLivro);
    }

    public void excluir(Long livroId){
        Livro livro = verificaExistencia(livroId);

        livroRepository.deleteById(livroId);
    }

}
