package com.example.api_filmes.exceptions;

public class DiretorNaoEncontradoException extends RuntimeException{

    public DiretorNaoEncontradoException(Long id){
        super("Diretor não encontrado com o id: " + id);
    }
}