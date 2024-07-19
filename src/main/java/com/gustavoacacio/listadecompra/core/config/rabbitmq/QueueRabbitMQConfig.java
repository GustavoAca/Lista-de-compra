package com.gustavoacacio.listadecompra.core.config.rabbitmq;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueueRabbitMQConfig {

    public final static String TOPICO_LISTA_CRIOU_HISTORICO = "default.lista";

    public final static List<String> TOPICOS_A_SEREM_CRIADOS = List.of(TOPICO_LISTA_CRIOU_HISTORICO);
}
