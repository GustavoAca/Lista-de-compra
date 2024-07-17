package com.gustavoacacio.listadecompra.producer;

import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static com.gustavoacacio.listadecompra.core.config.QueueRabbitMQConfig.TOPICO_LISTA_CRIOU_HISTORICO;

@Component
public class ItemProducer {

    private final RabbitTemplate rabbitTemplate;

    public ItemProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void fabricarHistorico(ItemDto itemDto){
        rabbitTemplate.convertAndSend("", TOPICO_LISTA_CRIOU_HISTORICO, itemDto);
    }
}
