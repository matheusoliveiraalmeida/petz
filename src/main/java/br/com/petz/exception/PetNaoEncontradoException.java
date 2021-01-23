package br.com.petz.exception;

public class PetNaoEncontradoException extends RuntimeException {
    public PetNaoEncontradoException(String exception) {
        super(exception);
    }
}
