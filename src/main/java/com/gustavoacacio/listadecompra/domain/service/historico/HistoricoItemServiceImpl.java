package com.gustavoacacio.listadecompra.domain.service.historico;

import com.gustavoacacio.listadecompra.core.service.ServiceAbstract;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import com.gustavoacacio.listadecompra.domain.repository.CompraRepository;
import com.gustavoacacio.listadecompra.domain.repository.HistoricoItemRepository;
import com.gustavoacacio.listadecompra.domain.service.compra.CompraService;
import org.springframework.stereotype.Service;

@Service
public class HistoricoItemServiceImpl extends ServiceAbstract<HistoricoItem, Long, HistoricoItemRepository> implements HistoricoItemService {
    protected HistoricoItemServiceImpl(HistoricoItemRepository repo){
        super(repo);
    }
}
