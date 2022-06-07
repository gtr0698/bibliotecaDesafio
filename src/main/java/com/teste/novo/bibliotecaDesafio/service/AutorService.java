package com.teste.novo.bibliotecaDesafio.service;

import com.teste.novo.bibliotecaDesafio.dto.autor.CreateAutorRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.autor.UpdateAutorRequestDto;
import com.teste.novo.bibliotecaDesafio.exception.RegraException;
import com.teste.novo.bibliotecaDesafio.model.Autor;
import com.teste.novo.bibliotecaDesafio.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;


    public Autor salvar(CreateAutorRequestDto autor){

        Autor autorNovo = autor.converToModel();

        return autorRepository.save(autorNovo);
    }

    public Page<Autor> listar(Pageable pageable){
        return autorRepository.findAll(pageable);
    }

    public Autor buscar(Long autorId){
        Autor autor = verificaExistente(autorId);

        return autor;
    }

    public Autor verificaExistente(Long autorId) {
        Optional<Autor> autor = autorRepository.findById(autorId);

        if(autor.isEmpty()){
            throw new RegraException("Autor não localizado!");
        }

        return autor.get();
    }

    public Autor atualizar(Long autorId, UpdateAutorRequestDto request){
        Autor autor = verificaExistente(autorId);
        Autor autorAtualiza = autor.atualizaAutor(request.getNome(), request.getEmail(), request.getDescricao());

        return autorRepository.save(autorAtualiza);
    }

    public void excluir(Long autorId){

        verificaExistente(autorId);

        autorRepository.deleteById(autorId);
    }

}
