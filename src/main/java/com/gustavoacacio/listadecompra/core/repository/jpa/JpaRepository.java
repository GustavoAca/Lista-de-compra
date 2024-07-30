package com.gustavoacacio.listadecompra.core.repository.jpa;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.core.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface JpaRepository<E extends EntityAbstract, K extends Serializable>
        extends org.springframework.data.jpa.repository.JpaRepository<E, K>,
        JpaSpecificationExecutor<E>, BaseRepository<E, K> {
}
