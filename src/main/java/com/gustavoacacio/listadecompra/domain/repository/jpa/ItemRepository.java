package com.gustavoacacio.listadecompra.domain.repository.jpa;

import com.gustavoacacio.listadecompra.core.repository.jpa.JpaRepository;
import com.gustavoacacio.listadecompra.domain.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends org.springframework.data.jpa.repository.JpaRepository<Item, Long>, JpaRepository<Item, Long> {
    Page<Item> findAllByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
