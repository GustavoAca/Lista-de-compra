package com.gustavoacacio.listadecompra.domain.service.historico.tipohistorico;

import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;

public interface TipoHistoricoService {
    HistoricoItem fabricar(HistoricoItemDto entity);
}
