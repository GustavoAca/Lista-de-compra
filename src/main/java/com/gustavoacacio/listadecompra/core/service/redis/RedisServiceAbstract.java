package com.gustavoacacio.listadecompra.core.service.redis;

import com.gustavoacacio.listadecompra.core.repository.redis.RedisRepository;

import java.io.Serializable;

public class RedisServiceAbstract<E extends Serializable, K extends Serializable, R extends RedisRepository<E, K>> implements RedisService<E, K> {
    protected R repo;

    protected RedisServiceAbstract(R repo) {
        this.repo = repo;
    }
}
