package com.gustavoacacio.listadecompra.core.service;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public interface BaseService <T extends EntityAbstract, K extends Serializable> {
    T salvar(T entity);

    Page<T> listarPagina(Pageable pageable);

    Optional<T> buscarPorId(K id);
}
