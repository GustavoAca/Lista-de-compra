package com.gustavoacacio.listadecompra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class UsuarioNaoCadastradoException extends ListaExcepion {

    private String username;

    public UsuarioNaoCadastradoException(String username) {
        this.username = username;
    }

    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Usuário não está cadastrado");
        pb.setDetail(String.format("Usuário %s não está cadastrado", this.username));
        return pb;
    }
}
