package com.gustavoacacio.listadecompra.core.repository.redis;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface RedisRepository<E extends Serializable, K extends Serializable> extends CrudRepository<E, K> {
}
