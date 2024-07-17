package com.gustavoacacio.listadecompra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class RegistroNaoEncontradoException extends ListaExcepion {
    private final Long id;
    private final String registro;

    public RegistroNaoEncontradoException(Long id, String registro) {
        this.id = id;
        this.registro = registro;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        pb.setTitle(String.format("%s não encontrado com o id: %d", registro, id));
        return pb;
    }
}
