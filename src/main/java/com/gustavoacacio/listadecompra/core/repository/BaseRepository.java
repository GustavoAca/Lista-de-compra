package com.gustavoacacio.listadecompra.core.repository;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BaseRepository<E extends EntityAbstract, K extends Serializable> extends JpaRepository<E, K>, JpaSpecificationExecutor<E> {
}
