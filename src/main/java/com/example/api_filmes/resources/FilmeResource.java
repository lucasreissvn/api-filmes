package com.example.api_filmes.resources;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_filmes.entities.Filme;
import com.example.api_filmes.services.FilmeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/filmes")


public class FilmeResource {

    private FilmeService filmeService;

    public FilmeResource(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @PostMapping()
    public ResponseEntity<Filme> salvarFilme(@RequestBody Filme filme) {
        Filme filmeSalvo = filmeService.salvarFilme(filme);
        return ResponseEntity.ok().body(filmeSalvo);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscaPorId(@PathVariable Long id){
        Optional<Filme> filme = filmeService.buscarPorId(id);
        return ResponseEntity.ok().body(filme.get());
    }
}
