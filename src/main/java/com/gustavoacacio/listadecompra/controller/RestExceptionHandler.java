package com.gustavoacacio.listadecompra.controller;

import com.gustavoacacio.listadecompra.exception.ListaExcepion;
import org.hibernate.PersistentObjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ListaExcepion.class)
    public ProblemDetail handleListaException(ListaExcepion e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var fieldErros = e.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
                .toList();
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Your request parameters didn't validate");
        pb.setProperty("invalid-params", fieldErros);
        return pb;
    }

    @ExceptionHandler(PersistentObjectException.class)
    public ProblemDetail handlePersistentObjectException(PersistentObjectException e) {
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Erro ao persistir dados");
        return pb;
    }

    private record InvalidParam(String fieldName, String reason) {
    }
}