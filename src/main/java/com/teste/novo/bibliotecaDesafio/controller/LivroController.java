package com.teste.novo.bibliotecaDesafio.controller;

import com.teste.novo.bibliotecaDesafio.dto.livro.CreateLivroRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.livro.LivroResponseDto;
import com.teste.novo.bibliotecaDesafio.dto.livro.UpdateLivroRequestDto;
import com.teste.novo.bibliotecaDesafio.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroResponseDto>adicionar(@Valid @RequestBody CreateLivroRequestDto livro){
        LivroResponseDto livroNovo = new LivroResponseDto(livroService.salvar(livro));

        return ResponseEntity.ok(livroNovo);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponseDto>>listar(Pageable pageable){
        List<LivroResponseDto> livros = livroService.listar(pageable).stream()
                .map(LivroResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/{livroId}")
    public ResponseEntity<LivroResponseDto>buscar(@PathVariable Long livroId){
        LivroResponseDto livroLocalizado = new LivroResponseDto(livroService.buscar(livroId));

        return ResponseEntity.ok(livroLocalizado);
    }

    @PutMapping("/{livroId}")
    public ResponseEntity<LivroResponseDto>atualizar(@Valid @PathVariable Long livroId,
                                                     @RequestBody UpdateLivroRequestDto request){
        LivroResponseDto livroAtualizado = new LivroResponseDto(livroService.atualizar(livroId, request));

        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{livroId}")
    public ResponseEntity<?>remover(@PathVariable Long livroId){
        livroService.excluir(livroId);

        return ResponseEntity.noContent().build();

    }


}
