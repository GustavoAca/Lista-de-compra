package com.gustavoacacio.listadecompra.core.config.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.gustavoacacio.listadecompra.core.config.rabbitmq.QueueRabbitMQConfig.TOPICOS_A_SEREM_CRIADOS;

@Configuration
public class RabbitMQConfig {

    private final ObjectMapper objectMapper;

    public RabbitMQConfig(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

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
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
