package com.gustavoacacio.listadecompra.domain.repository;

import com.gustavoacacio.listadecompra.core.repository.BaseRepository;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoItemRepository extends JpaRepository<HistoricoItem, Long>, BaseRepository<HistoricoItem, Long> {

    Page<HistoricoItem> findByCompraId(Long compraId, Pageable pageable);

    Page<HistoricoItem> findByItemId(Long itemId, Pageable pageable);
}
