package com.gustavoacacio.listadecompra.domain.service.historico;

import com.gustavoacacio.listadecompra.core.service.BaseService;
import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HistoricoItemService extends BaseService<HistoricoItem, Long> {

    Page<HistoricoItemDto> listarPorCompraId(Long compraId, Pageable pageable);

    Page<HistoricoItemDto> listarPorItemId(Long compraId, Pageable pageable);

}
