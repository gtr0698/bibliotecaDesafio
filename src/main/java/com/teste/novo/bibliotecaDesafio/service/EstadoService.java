package com.teste.novo.bibliotecaDesafio.service;

import com.teste.novo.bibliotecaDesafio.dto.estado.CreateEstadoRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.estado.UpdateEstadoRequestDto;
import com.teste.novo.bibliotecaDesafio.exception.RegraException;
import com.teste.novo.bibliotecaDesafio.model.Estado;
import com.teste.novo.bibliotecaDesafio.model.Pais;
import com.teste.novo.bibliotecaDesafio.repository.EstadoRepository;
import com.teste.novo.bibliotecaDesafio.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private PaisRepository paisRepository;

    public Estado salvar(CreateEstadoRequestDto estadoDto){
        Pais pais = paisRepository.findById(estadoDto.getPais().getId()).orElseThrow(() ->

                new RegraException("Pais não localizado com o id = " + estadoDto.getPais().getId(), "Pais"));

        Estado estadoNovo = estadoDto.convertToModel(pais);

        return estadoRepository.save(estadoNovo);
    }

    public Page<Estado> listar(Pageable pageable){
        return estadoRepository.findAll(pageable);
    }

    public Estado buscar(Long estadoId){
        Estado localizaEstado = verificaExistencia(estadoId);

        return localizaEstado;
    }

    public Estado verificaExistencia(Long estadoId) {
        Optional<Estado> estadoExistente = estadoRepository.findById(estadoId);

        if(estadoExistente.isEmpty()){
            throw new RegraException("Estado não localizado");
        }

        return estadoExistente.get();
    }

    public Estado atualizar(Long estadoId, UpdateEstadoRequestDto request){
        Estado estado = verificaExistencia(estadoId);
        Estado atualizarEstado = estado.atualizaEstado(request.getNome(), request.getPais());

        return estadoRepository.save(atualizarEstado);
    }

    public void excluir(Long estadoId){
        verificaExistencia(estadoId);
        estadoRepository.deleteById(estadoId);
    }

    public List<Estado>listaPorPais(Long pais){
        List<Estado> listaPais = estadoRepository.findByPaisId(pais);

        return listaPais;
    }

}
