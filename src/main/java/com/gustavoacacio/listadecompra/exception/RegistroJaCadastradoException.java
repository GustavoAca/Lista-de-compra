package com.gustavoacacio.listadecompra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class RegistroJaCadastradoException extends ListaExcepion {
    private final String mensagem;

    public RegistroJaCadastradoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        pb.setTitle("Registro já cadastrado");
        pb.setDetail(mensagem);
        return pb;
    }
}
