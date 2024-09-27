package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.User;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.model.dto.CarrinhoDeCompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CarrinhoDeCompraMapper {

    private final ItemMapper ItemMapper;

    public CarrinhoDeCompraMapper(ItemMapper ItemMapper) {
        this.ItemMapper = ItemMapper;
    }

    public CarrinhoDeCompraDto toDto(CarrinhoDeCompra entity) {
        CarrinhoDeCompraDto carrinhoDeCompraDto = CarrinhoDeCompraDto.builder()
                .id(entity.getId())
                .itens(toItensDtos(entity.getItens()))
                .userId(entity.getUsuario().getId())
                .createdBy(entity.getCreatedBy())
                .createdDate(entity.getCreatedDate())
                .modifiedDate(entity.getModifiedDate())
                .modifiedBy(entity.getModifiedBy())
                .build();

        if (Objects.nonNull(entity.getVersion())) {
            carrinhoDeCompraDto.setVersion(entity.getVersion());
        }
        return carrinhoDeCompraDto;
    }

    private List<ItemDto> toItensDtos(List<Item> itens) {
        return itens.stream().map(ItemMapper::toDto).toList();
    }

    public CarrinhoDeCompra toEntity(CarrinhoDeCompraDto dto) {
        CarrinhoDeCompra carrinhoDeCompra = CarrinhoDeCompra.builder()
                .id(dto.getId())
                .itens(toItensEntity(dto.getItens()))
                .usuario(User.builder().id(dto.getUserId()).build())
                .createdDate(dto.getCreatedDate())
                .createdBy(dto.getCreatedBy())
                .modifiedBy(dto.getModifiedBy())
                .modifiedDate(dto.getModifiedDate())
                .build();
        if (Objects.nonNull(dto.getVersion())) {
            carrinhoDeCompra.setVersion(dto.getVersion());
        }

        return carrinhoDeCompra;
    }

    private List<Item> toItensEntity(List<ItemDto> itensDtos) {
        return itensDtos.stream().map(ItemMapper::toEntity).toList();
    }
}
