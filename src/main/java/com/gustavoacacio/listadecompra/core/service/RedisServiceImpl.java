package com.gustavoacacio.listadecompra.core.service;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.core.repository.redis.RedisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public class RedisServiceImpl<E extends EntityAbstract, K extends Serializable, R extends RedisRepository<E, K>> implements BaseServiceAbstract<E, K> {
    protected R repo;

    protected RedisServiceImpl(R repo) {
        this.repo = repo;
    }

    public E salvar(E entity) {
        return this.repo.save(entity);
    }

    @Override
    public Page<E> listarPagina(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<E> buscarPorId(K id) {
        return repo.findById(id);
    }

    @Override
    public Boolean deletar(K id) {
        repo.deleteById(id);
        return repo.existsById(id);
    }
}
