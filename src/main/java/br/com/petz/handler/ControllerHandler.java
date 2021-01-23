package br.com.petz.handler;

import br.com.petz.exception.ClienteNaoEncontradoException;
import br.com.petz.exception.PetNaoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ControllerHandler {

    @ExceptionHandler({ ClienteNaoEncontradoException.class })
    public ResponseEntity<?> clienteNaoEncontrado(ClienteNaoEncontradoException clienteNaoEncontrado){
        return ResponseEntity.status(NOT_FOUND)
                .body(clienteNaoEncontrado.getMessage());
    }

    @ExceptionHandler({ PetNaoEncontradoException.class })
    public ResponseEntity<?> petNaoEncontrado(PetNaoEncontradoException petNaoEncontrado){
        return ResponseEntity.status(NOT_FOUND)
                .body(petNaoEncontrado.getMessage());
    }

}