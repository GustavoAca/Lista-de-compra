package com.gustavoacacio.listadecompra.domain.repository;

import com.gustavoacacio.listadecompra.core.repository.redis.RedisRepository;
import com.gustavoacacio.listadecompra.domain.model.CarrinhoDeCompra;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoDeCompraRepository extends RedisRepository<CarrinhoDeCompra, String> {
}
