package com.cti.cadastro_filme.controller;

import com.cti.cadastro_filme.business.FilmeService;
import com.cti.cadastro_filme.infrastructure.entities.Filme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filme")
@RequiredArgsConstructor
public class FilmeController {
    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Filme filme){
        filmeService.salvarFilme(filme);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Filme> buscarFilmePorTitulo(@RequestParam String titulo){
        return ResponseEntity.ok(filmeService.buscarFilmePorTitulo(titulo));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarFilmePorTitulo(@RequestParam String titulo){
        filmeService.deletarFilmePorTitulo(titulo);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarFilmePorId(@RequestParam Integer id,
                                                      @RequestBody Filme filme){
        filmeService.atualizarFilmePorId(id, filme);
        return ResponseEntity.ok().build();
    }
}