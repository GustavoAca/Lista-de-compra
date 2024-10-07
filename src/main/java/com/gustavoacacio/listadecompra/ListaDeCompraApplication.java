package com.gustavoacacio.listadecompra;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

@SpringBootApplication
@ComponentScan(value = "com.gustavoacacio.listadecompra.domain.model")
public class ListaDeCompraApplication {

    public static void main(String[] args) {
        SpringApplication.run(ListaDeCompraApplication.class, args);
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }
}
