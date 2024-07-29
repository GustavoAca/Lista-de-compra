package com.gustavoacacio.listadecompra.core.service;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.core.repository.jpa.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public class JpaServiceImpl<E extends EntityAbstract, K extends Serializable, R extends JpaRepository<E, K>> implements BaseServiceAbstract<E, K> {
    protected R repo;

    protected JpaServiceImpl(R repo) {
        this.repo = repo;
    }

    public E salvar(E entity) {
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

    @Override
    public Boolean deletar(K id) {
        repo.deleteById(id);
        return repo.existsById(id);
    }
}
