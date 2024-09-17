package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.ItemNoCarrinho;
import com.gustavoacacio.listadecompra.domain.model.User;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.model.dto.CarrinhoDeCompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemNoCarrinhoDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarrinhoDeCompraMapper {

    private final ItemNoCarrinhoMapper itemNoCarrinhoMapper;

    public CarrinhoDeCompraMapper(ItemNoCarrinhoMapper itemNoCarrinhoMapper) {
        this.itemNoCarrinhoMapper = itemNoCarrinhoMapper;
    }

    public CarrinhoDeCompraDto toDto(CarrinhoDeCompra entity) {
        return CarrinhoDeCompraDto.builder()
                .id(entity.getId())
                .itens(toItensDtos(entity.getItens()))
                .userId(entity.getUsuario().getId())
                .createdBy(entity.getCreatedBy())
                .createdDate(entity.getCreatedDate())
                .modifiedDate(entity.getModifiedDate())
                .modifiedBy(entity.getModifiedBy())
                .build();
    }

    private List<ItemNoCarrinhoDto> toItensDtos(List<ItemNoCarrinho> itens) {
        return itens.stream().map(itemNoCarrinhoMapper::toDto).toList();
    }

    public CarrinhoDeCompra toEntity(CarrinhoDeCompraDto dto) {
        return CarrinhoDeCompra.builder()
                .id(dto.getId())
                .itens(toItensEntity(dto.getItens()))
                .usuario(User.builder().id(dto.getUserId()).build())
                .createdDate(dto.getCreatedDate())
                .createdBy(dto.getCreatedBy())
                .modifiedBy(dto.getModifiedBy())
                .modifiedDate(dto.getModifiedDate())
                .build();
    }

    private List<ItemNoCarrinho> toItensEntity(List<ItemNoCarrinhoDto> itensDtos) {
        return itensDtos.stream().map(itemNoCarrinhoMapper::toEntity).toList();
    }

}
