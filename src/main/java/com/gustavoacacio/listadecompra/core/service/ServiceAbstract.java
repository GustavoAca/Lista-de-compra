package com.gustavoacacio.listadecompra.core.service;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.core.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public class ServiceAbstract<E extends EntityAbstract, K extends Serializable, R extends BaseRepository<E, K>> implements  BaseService<E, K> {
    protected R repo;

    protected ServiceAbstract(R repo){
        this.repo = repo;
    }
    public E salvar(E entity){
        return this.repo.save(entity);
    }

    @Override
    public Page<E> listarPagina(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Optional<E> buscarPorId(K id) {
        return repo.findById(id);
    }
}
