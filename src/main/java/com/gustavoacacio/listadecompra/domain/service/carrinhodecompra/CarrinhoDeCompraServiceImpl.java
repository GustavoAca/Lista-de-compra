package com.gustavoacacio.listadecompra.domain.service.carrinhodecompra;

import com.gustavoacacio.listadecompra.core.service.redis.RedisServiceAbstract;
import com.gustavoacacio.listadecompra.domain.model.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.repository.CarrinhoDeCompraRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoDeCompraServiceImpl extends RedisServiceAbstract<CarrinhoDeCompra, String, CarrinhoDeCompraRepository> implements CarrinhoDeCompraService {

    protected CarrinhoDeCompraServiceImpl(CarrinhoDeCompraRepository repo) {
        super(repo);
    }
}
