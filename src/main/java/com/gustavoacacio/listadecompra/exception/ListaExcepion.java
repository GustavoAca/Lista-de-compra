package com.gustavoacacio.listadecompra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class ListaExcepion extends RuntimeException {

    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Erro interno");
        return pb;
    }
}
