package com.gustavoacacio.listadecompra.domain.service.carrinhodecompra;

import com.gustavoacacio.listadecompra.core.service.RedisServiceImpl;
import com.gustavoacacio.listadecompra.domain.model.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.repository.redis.CarrinhoDeCompraRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoDeCompraServiceImpl extends RedisServiceImpl<CarrinhoDeCompra, String, CarrinhoDeCompraRepository> implements CarrinhoDeCompraService {

    protected CarrinhoDeCompraServiceImpl(CarrinhoDeCompraRepository repo) {
        super(repo);
    }
}
