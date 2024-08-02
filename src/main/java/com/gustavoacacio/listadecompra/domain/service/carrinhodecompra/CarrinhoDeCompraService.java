package com.gustavoacacio.listadecompra.domain.service.carrinhodecompra;

import com.gustavoacacio.listadecompra.core.service.redis.RedisService;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.model.dto.CarrinhoDeCompraDto;

public interface CarrinhoDeCompraService extends RedisService<CarrinhoDeCompra, String> {

    CarrinhoDeCompraDto salvar(CarrinhoDeCompraDto compraDto);

    CarrinhoDeCompraDto getUltimoCarrinho();
}
