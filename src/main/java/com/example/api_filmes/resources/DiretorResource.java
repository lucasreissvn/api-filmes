package com.example.api_filmes.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_filmes.dto.DiretorDTO;
import com.example.api_filmes.entities.Diretor;
import com.example.api_filmes.services.DiretorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/diretores")
public class DiretorResource{

    private final DiretorService diretorService;

    public DiretorResource(DiretorService diretorService) {
        this.diretorService = diretorService;
    }

    @PostMapping
    public ResponseEntity<Diretor> salvarDiretor(@Valid @RequestBody DiretorDTO diretorDTO){
        Diretor diretorSalvo = diretorService.salvarDiretor(diretorDTO);
        return ResponseEntity.ok().body(diretorSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Diretor>> buscarTodos(){
        List<Diretor> diretores = diretorService.buscarTodos();
        return ResponseEntity.ok().body(diretores);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Diretor> buscarPorId(@PathVariable Long id){
        Diretor diretor = diretorService.buscarPorId(id);
        return ResponseEntity.ok().body(diretor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diretor> atualizarDiretor(@PathVariable Long id, @Valid @RequestBody DiretorDTO diretorDTO){
        Diretor diretorAtualizado = diretorService.atualizarDiretor(id, diretorDTO);
        return ResponseEntity.ok().body(diretorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDiretor(@PathVariable Long id){
        diretorService.deletarDiretor(id);
        return ResponseEntity.noContent().build();
    }
}