package com.gustavoacacio.listadecompra.domain.repository;

import com.gustavoacacio.listadecompra.core.repository.BaseRepository;
import com.gustavoacacio.listadecompra.domain.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, BaseRepository<Item, Long> {
    Page<Item> findAllByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
