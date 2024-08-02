package com.gustavoacacio.listadecompra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ExtrairUsuarioLogadoException extends ListaExcepion {

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);
        pb.setTitle("Impossivel extrair usuário logado");
        pb.setDetail("Não foi possível extrarir usuario logado");
        return pb;
    }
}
