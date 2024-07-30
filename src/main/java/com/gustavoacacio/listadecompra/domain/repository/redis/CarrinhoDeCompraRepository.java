package com.gustavoacacio.listadecompra.domain.repository.redis;

import com.gustavoacacio.listadecompra.core.repository.redis.RedisRepository;
import com.gustavoacacio.listadecompra.domain.model.CarrinhoDeCompra;

public interface CarrinhoDeCompraRepository extends RedisRepository<CarrinhoDeCompra, String> {
}
