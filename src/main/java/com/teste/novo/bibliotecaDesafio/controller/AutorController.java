package com.teste.novo.bibliotecaDesafio.controller;

import com.teste.novo.bibliotecaDesafio.dto.autor.AutorResponseDto;
import com.teste.novo.bibliotecaDesafio.dto.autor.CreateAutorRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.autor.UpdateAutorRequestDto;
import com.teste.novo.bibliotecaDesafio.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorResponseDto>adicionar(@Valid @RequestBody CreateAutorRequestDto autor){
        AutorResponseDto novoAutor = new AutorResponseDto(autorService.salvar(autor));

        return ResponseEntity.ok(novoAutor);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponseDto>>listar(Pageable pageable){
        List<AutorResponseDto> autores = autorService.listar(pageable).stream()
                .map(AutorResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.ok(autores);
    }

    @GetMapping("/{autorId}")
    public ResponseEntity<AutorResponseDto>buscar(@PathVariable Long autorId){
        AutorResponseDto localizaAutor = new AutorResponseDto(autorService.buscar(autorId));

        return ResponseEntity.ok(localizaAutor);
    }

    @PutMapping("/{autorId}")
    public ResponseEntity<AutorResponseDto>atualizar(@Valid @PathVariable Long autorId,
                                                     @RequestBody UpdateAutorRequestDto request){
        AutorResponseDto autorAtualizado = new AutorResponseDto(autorService.atualizar(autorId, request));

        return ResponseEntity.ok(autorAtualizado);
    }

    @DeleteMapping("/{autorId}")
    public ResponseEntity<?>remover(@PathVariable Long autorId){
        autorService.excluir(autorId);

        return ResponseEntity.noContent().build();
    }
}
