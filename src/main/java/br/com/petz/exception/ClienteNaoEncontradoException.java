package br.com.petz.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(String exception) {
        super(exception);
    }
}
