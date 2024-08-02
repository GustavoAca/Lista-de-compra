package com.gustavoacacio.listadecompra.domain.service.carrinhodecompra;

import com.gustavoacacio.listadecompra.core.service.JpaServiceImpl;
import com.gustavoacacio.listadecompra.domain.mapper.CarrinhoDeCompraMapper;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.model.dto.CarrinhoDeCompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemNoCarrinhoDto;
import com.gustavoacacio.listadecompra.domain.repository.jpa.CarrinhoDeCompraRepository;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoDeCompraServiceImpl extends JpaServiceImpl<CarrinhoDeCompra, Long, CarrinhoDeCompraRepository> implements CarrinhoDeCompraService {

    private final CarrinhoDeCompraMapper carrinhoDeCompraMapper;

    protected CarrinhoDeCompraServiceImpl(CarrinhoDeCompraRepository repo,
                                          CarrinhoDeCompraMapper carrinhoDeCompraMapper) {
        super(repo);
        this.carrinhoDeCompraMapper = carrinhoDeCompraMapper;
    }

    @Override
    public CarrinhoDeCompraDto salvar(CarrinhoDeCompraDto carrinhoDeCompraDto) {
        var carrinho = carrinhoDeCompraMapper.toDto(super.salvar(carrinhoDeCompraMapper.toEntity(CarrinhoDeCompraDto.builder().build())));
        carrinho.setItens(carrinhoDeCompraDto.getItens());
        for (ItemNoCarrinhoDto itemNoCarrinho : carrinho.getItens()) {
            itemNoCarrinho.setCarrinhoDeCompra(carrinho.getId());
        }
        return carrinhoDeCompraMapper.toDto(super.salvar(carrinhoDeCompraMapper.toEntity(carrinhoDeCompraDto)));
    }

    @Override
    public CarrinhoDeCompraDto getUltimoCarrinho() {
        return null;
    }
}
