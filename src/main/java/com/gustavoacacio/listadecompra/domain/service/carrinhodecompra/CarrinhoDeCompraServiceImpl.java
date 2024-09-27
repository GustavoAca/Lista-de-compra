package com.gustavoacacio.listadecompra.domain.service.carrinhodecompra;

import com.gustavoacacio.listadecompra.core.service.JpaServiceImpl;
import com.gustavoacacio.listadecompra.core.utils.SecurityContextUtils;
import com.gustavoacacio.listadecompra.domain.mapper.CarrinhoDeCompraMapper;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.model.dto.CarrinhoDeCompraDto;
import com.gustavoacacio.listadecompra.domain.repository.jpa.CarrinhoDeCompraRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        var carrinho = carrinhoDeCompraMapper.toDto(pegarCarrinhoOuFabricar());
        carrinho.setItens(carrinhoDeCompraDto.getItens());
        return carrinhoDeCompraMapper.toDto(this.salvar(carrinhoDeCompraMapper.toEntity(carrinho)));
    }

    private CarrinhoDeCompra pegarCarrinhoOuFabricar() {
        var car = repo.findCarrinhoPorUserId(SecurityContextUtils.getId());
        return car.orElseGet(() -> this.salvar(carrinhoDeCompraMapper.toEntity(CarrinhoDeCompraDto.builder().userId(SecurityContextUtils.getId()).build())));
    }

    @Override
    public CarrinhoDeCompraDto encontrarPorUser() {
        Optional<CarrinhoDeCompra> carrinhoDeCompra = repo.findCarrinhoPorUserId(SecurityContextUtils.getId());
        if (carrinhoDeCompra.isPresent()) {
            carrinhoDeCompra.map(carrinhoDeCompraMapper::toDto);

        }
        return CarrinhoDeCompraDto.builder().build();
    }
}
