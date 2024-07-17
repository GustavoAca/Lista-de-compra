package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .nome(item.getNome())
                .quantidade(item.getQuantidade())
                .valor(item.getValor())
                .compraId(item.getCompra().getId())
                .createdBy(item.getCreatedBy())
                .createdDate(item.getCreatedDate())
                .modifiedBy(item.getModifiedBy())
                .modifiedDate(item.getModifiedDate())
                .build();
    }

    public Item toEntity(ItemDto item) {
        return Item.builder()
                .id(item.getId())
                .nome(item.getNome())
                .quantidade(item.getQuantidade())
                .compra(Compra.builder().id(item.getCompraId()).build())
                .valor(item.getValor())
                .createdBy(item.getCreatedBy())
                .createdDate(item.getCreatedDate())
                .modifiedBy(item.getModifiedBy())
                .modifiedDate(item.getModifiedDate())
                .build();
    }
}
