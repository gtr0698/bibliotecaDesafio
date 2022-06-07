package com.teste.novo.bibliotecaDesafio.controller;

import com.teste.novo.bibliotecaDesafio.dto.estado.CreateEstadoRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.estado.EstadoResponseDto;
import com.teste.novo.bibliotecaDesafio.dto.estado.UpdateEstadoRequestDto;
import com.teste.novo.bibliotecaDesafio.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @PostMapping
    public ResponseEntity<EstadoResponseDto>adicionar(@Valid @RequestBody CreateEstadoRequestDto estado){
        EstadoResponseDto novoEstado = new EstadoResponseDto(estadoService.salvar(estado));

        return ResponseEntity.ok(novoEstado);
    }

    @GetMapping()
    public ResponseEntity<List<EstadoResponseDto>>listar(Pageable pageable){
        List<EstadoResponseDto> estados = estadoService.listar(pageable).stream()
                .map(EstadoResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.ok(estados);
    }

    @GetMapping("/{estadoId}")
    public ResponseEntity<EstadoResponseDto>buscar(@PathVariable Long estadoId){
        EstadoResponseDto estadoLocalizado = new EstadoResponseDto(estadoService.buscar(estadoId));

        return ResponseEntity.ok(estadoLocalizado);
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<EstadoResponseDto>atualizar(@Valid @PathVariable Long estadoId,
                                                      @RequestBody UpdateEstadoRequestDto request){
        EstadoResponseDto estadoAtualizado = new EstadoResponseDto(estadoService.atualizar(estadoId, request));

        return ResponseEntity.ok(estadoAtualizado);
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<?>remover(@PathVariable Long estadoId){

        estadoService.excluir(estadoId);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pais/{paisId}")
    public ResponseEntity<List<EstadoResponseDto>>listarEstadosPorPais(@PathVariable Long paisId){
        List<EstadoResponseDto> listaEstados = estadoService.listaPorPais(paisId).stream()
                .map(EstadoResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.ok(listaEstados);
    }


}
