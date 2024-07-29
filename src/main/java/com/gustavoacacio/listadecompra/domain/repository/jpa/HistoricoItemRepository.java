package com.gustavoacacio.listadecompra.domain.repository.jpa;

import com.gustavoacacio.listadecompra.core.repository.jpa.JpaRepository;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoItemRepository extends org.springframework.data.jpa.repository.JpaRepository<HistoricoItem, Long>, JpaRepository<HistoricoItem, Long> {

    Page<HistoricoItem> findByCompraId(Long compraId, Pageable pageable);

    Page<HistoricoItem> findByItemId(Long itemId, Pageable pageable);
}
