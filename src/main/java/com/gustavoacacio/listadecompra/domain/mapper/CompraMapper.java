package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class CompraMapper {

    private final ItemMapper itemMapper;

    public CompraMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public Compra toEntity(CompraDto compraDto) {
        var c = Compra.builder().id(compraDto.getId())
                .itens(toListItemsEntity(compraDto.getItems()))
                .valorTotal(compraDto.getValorTotal())
                .createdBy(compraDto.getCreatedBy())
                .createdDate(compraDto.getCreatedDate())
                .modifiedBy(compraDto.getModifiedBy())
                .modifiedDate(compraDto.getModifiedDate())
                .build();

        if (Objects.nonNull(compraDto.getVersion())) c.setVersion(compraDto.getVersion());

        return c;
    }

    private List<Item> toListItemsEntity(List<ItemDto> items) {
        if (items.isEmpty()) return Collections.emptyList();
        return items.stream().map(itemMapper::toEntity).toList();
    }

    public CompraDto toDto(Compra compra) {
        var c = CompraDto.builder().id(compra.getId())
                .items(toListItensDto(compra.getItens()))
                .valorTotal(compra.getValorTotal())
                .createdBy(compra.getCreatedBy())
                .createdDate(compra.getCreatedDate())
                .modifiedBy(compra.getModifiedBy())
                .modifiedDate(compra.getModifiedDate())
                .build();

        if (Objects.nonNull(compra.getVersion())) c.setVersion(compra.getVersion());

        return c;
    }

    private List<ItemDto> toListItensDto(List<Item> itens) {
        if (itens.isEmpty()) return Collections.emptyList();
        return itens.stream().map(itemMapper::toDto).toList();
    }
}
