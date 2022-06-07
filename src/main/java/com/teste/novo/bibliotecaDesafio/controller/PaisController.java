package com.teste.novo.bibliotecaDesafio.controller;

import com.teste.novo.bibliotecaDesafio.dto.pais.CreatePaisRequestDto;
import com.teste.novo.bibliotecaDesafio.dto.pais.PaisResponseDto;
import com.teste.novo.bibliotecaDesafio.dto.pais.UpdatePaisRequestDto;
import com.teste.novo.bibliotecaDesafio.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @PostMapping
    public ResponseEntity<PaisResponseDto>adicionar(@Valid @RequestBody CreatePaisRequestDto pais){
        PaisResponseDto novoPais = new PaisResponseDto(paisService.salvar(pais));

        return ResponseEntity.ok(novoPais);
    }

    @GetMapping
    public ResponseEntity<List<PaisResponseDto>>listar(Pageable pageable){
        List<PaisResponseDto>paises = paisService.listar(pageable).stream()
                .map(PaisResponseDto::new).collect(Collectors.toList());

        return ResponseEntity.ok(paises);
    }

    @GetMapping("/{paisId}")
    public ResponseEntity<PaisResponseDto>buscar(@PathVariable Long paisId){
        PaisResponseDto LocalizaPais = new PaisResponseDto(paisService.buscar(paisId));

        return ResponseEntity.ok(LocalizaPais);
    }

    @PutMapping("/{paisId}")
    public ResponseEntity<PaisResponseDto>atualizar(@Valid @PathVariable Long paisId,
                                                    @RequestBody UpdatePaisRequestDto request){
        PaisResponseDto paisAtualizado = new PaisResponseDto(paisService.atualizar(paisId, request));

        return ResponseEntity.ok(paisAtualizado);
    }

    @DeleteMapping("/{paisId}")
    public ResponseEntity<?>remover(@PathVariable Long paisId){

        paisService.excluir(paisId);

        return ResponseEntity.noContent().build();
    }


}
