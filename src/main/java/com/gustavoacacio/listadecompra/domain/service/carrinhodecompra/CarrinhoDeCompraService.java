package com.gustavoacacio.listadecompra.domain.service.carrinhodecompra;

import com.gustavoacacio.listadecompra.core.service.redis.RedisService;
import com.gustavoacacio.listadecompra.domain.model.CarrinhoDeCompra;

public interface CarrinhoDeCompraService extends RedisService<CarrinhoDeCompra, String> {
}
