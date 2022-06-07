package com.teste.novo.bibliotecaDesafio.controller;

import com.teste.novo.bibliotecaDesafio.dto.categoria.CategoriaResponseDto;
import com.teste.novo.bibliotecaDesafio.dto.categoria.CreateCategoriaRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.categoria.UpdateCategoriaRequestDto;
import com.teste.novo.bibliotecaDesafio.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<CategoriaResponseDto>adicionar(@Valid @RequestBody CreateCategoriaRequestDto categoria){
        CategoriaResponseDto novaCategoria = new CategoriaResponseDto(categoriaService.salvar(categoria));

        return ResponseEntity.ok(novaCategoria);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDto>>listar(Pageable pageable){
        List<CategoriaResponseDto> categorias = categoriaService.listar(pageable).stream()
                .map(CategoriaResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<CategoriaResponseDto>buscar(@PathVariable Long categoriaId){
        CategoriaResponseDto categoriaLocalizada = new CategoriaResponseDto(categoriaService.buscar(categoriaId));

        return ResponseEntity.ok(categoriaLocalizada);
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<CategoriaResponseDto>atualizar(@Valid @PathVariable Long categoriaId,
                                                         @RequestBody UpdateCategoriaRequestDto request){
        CategoriaResponseDto categoriaAtualizada = new CategoriaResponseDto(categoriaService.atualizar(categoriaId,
                request));

        return ResponseEntity.ok(categoriaAtualizada);
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<?>remover(@PathVariable Long categoriaId){

        categoriaService.excluir(categoriaId);

        return ResponseEntity.noContent().build();
    }

}
