package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class CompraMapper {

    private final ItemMapper itemMapper;

    public CompraMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public Compra toEntity(CompraDto compraDto) {
        return Compra.builder().id(compraDto.getId())
                .items(toListItemsEntity(compraDto.getItems()))
                .createdBy(compraDto.getCreatedBy())
                .createdDate(compraDto.getCreatedDate())
                .modifiedBy(compraDto.getModifiedBy())
                .modifiedDate(compraDto.getModifiedDate())
                .build();
    }

    private List<Item> toListItemsEntity(List<ItemDto> items) {
        if (items.isEmpty()) return Collections.emptyList();
        return items.stream().map(itemMapper::toEntity).toList();
    }

    public CompraDto toDto(Compra compra) {
        return CompraDto.builder().id(compra.getId())
                .items(toListItemsDto(compra.getItems()))
                .createdBy(compra.getCreatedBy())
                .createdDate(compra.getCreatedDate())
                .modifiedBy(compra.getModifiedBy())
                .modifiedDate(compra.getModifiedDate())
                .build();
    }

    private List<ItemDto> toListItemsDto(List<Item> items) {
        if (items.isEmpty()) return Collections.emptyList();
        return items.stream().map(itemMapper::toDto).toList();
    }
}
