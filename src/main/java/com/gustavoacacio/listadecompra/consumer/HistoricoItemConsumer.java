package com.gustavoacacio.listadecompra.consumer;

import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.TipoHistorico;
import com.gustavoacacio.listadecompra.domain.service.historico.HistoricoItemService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.gustavoacacio.listadecompra.core.config.QueueRabbitMQConfig.TOPICO_LISTA_CRIOU_HISTORICO;

@Component
public class HistoricoItemConsumer {

    private final HistoricoItemService historicoItemService;

    public HistoricoItemConsumer(HistoricoItemService historicoItemService) {
        this.historicoItemService = historicoItemService;
    }

    @RabbitListener(queues = TOPICO_LISTA_CRIOU_HISTORICO)
    public void listenItemQueue(@Payload ItemDto itemDto) {
        historicoItemService.salvar(TipoHistorico.TIPO_HISTORICO_ITEM.getFactory(itemDto));
    }
}
