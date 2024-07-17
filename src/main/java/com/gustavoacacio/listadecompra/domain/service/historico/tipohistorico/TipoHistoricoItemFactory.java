package com.gustavoacacio.listadecompra.domain.service.historico.tipohistorico;

import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import com.gustavoacacio.listadecompra.domain.model.historico.TipoHistoricoService;
import org.springframework.stereotype.Component;

@Component
public class TipoHistoricoItemFactory implements TipoHistoricoService<ItemDto, HistoricoItem> {

    @Override
    public HistoricoItem fabricar(ItemDto dto) {
        return HistoricoItem.builder()
                .compraId(dto.getCompraId())
                .itemId(dto.getId())
                .valorItem(dto.getValor())
                .build();
    }
}
