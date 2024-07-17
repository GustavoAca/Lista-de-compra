package com.gustavoacacio.listadecompra.core.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

import static com.gustavoacacio.listadecompra.core.config.QueueRabbitMQConfig.TOPICOS_A_SEREM_CRIADOS;

@Configuration
public class RabbitMQConfig {

    @Bean
    public String queues() {
        for (String queueName : TOPICOS_A_SEREM_CRIADOS) {
            queue(queueName);
        }
        return "Queue criadas!";
    }

    @Bean
    public Queue queue(String queueName) {
        return new Queue(queueName, true);
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
