package com.gustavoacacio.listadecompra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CredencialException extends ListaExcepion {

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Usuário ou senha inválidos");
        pb.setDetail("Usuário ou senha inválidos");
        return pb;
    }
}
