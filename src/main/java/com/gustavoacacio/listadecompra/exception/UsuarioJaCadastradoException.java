package com.gustavoacacio.listadecompra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UsuarioJaCadastradoException extends ListaExcepion {

    private String username;

    public UsuarioJaCadastradoException(String username) {
        this.username = username;
    }

    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle(String.format("Usuário %s já está cadastrado", this.username));
        return pb;
    }
}
