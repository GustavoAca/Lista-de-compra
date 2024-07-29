package com.gustavoacacio.listadecompra.domain.service.historico;

import com.gustavoacacio.listadecompra.core.service.JpaServiceImpl;
import com.gustavoacacio.listadecompra.domain.mapper.HistoricoItemMapper;
import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import com.gustavoacacio.listadecompra.domain.repository.jpa.HistoricoItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricoItemServiceImpl extends JpaServiceImpl<HistoricoItem, Long, HistoricoItemRepository> implements HistoricoItemService {

    private final HistoricoItemMapper historicoItemMapper;

    protected HistoricoItemServiceImpl(HistoricoItemRepository repo,
                                       HistoricoItemMapper historicoItemMapper) {
        super(repo);
        this.historicoItemMapper = historicoItemMapper;
    }

    @Override
    public Page<HistoricoItemDto> listarPorCompraId(Long compraId, Pageable pageable) {
        return converterPageEntityToDto(repo.findByCompraId(compraId, pageable), pageable);
    }

    @Override
    public Page<HistoricoItemDto> listarPorItemId(Long compraId, Pageable pageable) {
        return converterPageEntityToDto(repo.findByItemId(compraId, pageable), pageable);
    }

    private Page<HistoricoItemDto> converterPageEntityToDto(Page<HistoricoItem> historicoItems, Pageable pageable) {
        Page<HistoricoItem> historicoItemsPage = historicoItems;
        List<HistoricoItemDto> historicoItemDtos = historicoItemsPage.getContent()
                .stream()
                .map(historicoItemMapper::toDto)
                .toList();
        return new PageImpl<>(historicoItemDtos, pageable, historicoItemsPage.getTotalElements());

    }
}
