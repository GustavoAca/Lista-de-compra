package com.gustavoacacio.listadecompra.domain.service.historico.tipohistorico;

import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import org.springframework.stereotype.Component;

@Component
public class TipoHistoricoItemFactory implements TipoHistoricoService {

    @Override
    public HistoricoItem fabricar(HistoricoItemDto historicoItemDto) {
        return HistoricoItem.builder()
                .itemId(historicoItemDto.getItemId())
                .compraId(historicoItemDto.getCompraId())
                .valorItem(historicoItemDto.getValorItem())
                .localId(historicoItemDto.getLocalId())
                .build();
    }
}
