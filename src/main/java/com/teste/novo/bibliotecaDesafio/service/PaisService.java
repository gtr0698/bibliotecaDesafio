package com.teste.novo.bibliotecaDesafio.service;

import com.teste.novo.bibliotecaDesafio.dto.pais.CreatePaisRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.pais.UpdatePaisRequestDto;
import com.teste.novo.bibliotecaDesafio.exception.RegraException;
import com.teste.novo.bibliotecaDesafio.model.Pais;
import com.teste.novo.bibliotecaDesafio.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    public Pais salvar(CreatePaisRequestDto pais){

        Pais paisNovo = pais.convertToModel();

        return paisRepository.save(paisNovo);
    }

    public Page<Pais> listar(Pageable pageable){
        return paisRepository.findAll(pageable);
    }

    public Pais buscar(Long paisId){
        Pais paisLocalizado = verificaExistencia(paisId);

        return paisLocalizado;
    }

    public Pais verificaExistencia(Long paisId) {
        Optional<Pais> paisExistente = paisRepository.findById(paisId);

        if(paisExistente.isEmpty()){
            throw new RegraException("Pais não localizado");
        }

        return paisExistente.get();

    }

    public Pais atualizar(Long paisId, UpdatePaisRequestDto request){
        Pais pais = verificaExistencia(paisId);
        Pais atualizarPais = pais.atualizaPais(request.getNome());

        return paisRepository.save(atualizarPais);
    }

    public void excluir(Long paisId){
        verificaExistencia(paisId);
        paisRepository.deleteById(paisId);
    }
}
