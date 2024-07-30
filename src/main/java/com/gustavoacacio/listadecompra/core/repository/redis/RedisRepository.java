package com.gustavoacacio.listadecompra.core.repository.redis;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.core.repository.BaseRepository;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface RedisRepository<E extends EntityAbstract, K extends Serializable>
        extends CrudRepository<E, K>, BaseRepository<E, K> {
}
