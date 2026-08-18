package com.example.api_filmes.exceptions;

public class FilmeNaoEncontradoException extends RuntimeException {

    public FilmeNaoEncontradoException(Long id) {
        super("Filme não encontrado com o id: " + id);
    }
}