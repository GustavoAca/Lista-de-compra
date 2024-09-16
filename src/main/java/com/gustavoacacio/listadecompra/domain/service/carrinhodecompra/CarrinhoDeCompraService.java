package com.gustavoacacio.listadecompra.domain.service.carrinhodecompra;

import com.gustavoacacio.listadecompra.core.service.jpa.JpaService;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.model.dto.CarrinhoDeCompraDto;

import java.util.Optional;

public interface CarrinhoDeCompraService extends JpaService<CarrinhoDeCompra, Long> {

    CarrinhoDeCompraDto salvar(CarrinhoDeCompraDto compraDto);

    Optional<CarrinhoDeCompraDto> encontrarPorUser();
}
