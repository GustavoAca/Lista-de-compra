package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.ItemNoCarrinho;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemNoCarrinhoDto;
import org.springframework.stereotype.Component;

@Component
public class ItemNoCarrinhoMapper {

    public ItemNoCarrinhoDto toDto(ItemNoCarrinho item) {
        return ItemNoCarrinhoDto.builder()
                .id(item.getId())
                .nome(item.getNome())
                .quantidade(item.getQuantidade())
                .carrinhoDeCompra(item.getCarrinhoDeCompra().getId())
                .valor(item.getValor())
                .promocao(item.getPromocao())
                .createdBy(item.getCreatedBy())
                .createdDate(item.getCreatedDate())
                .modifiedBy(item.getModifiedBy())
                .modifiedDate(item.getModifiedDate())
                .build();
    }

    public ItemNoCarrinho toEntity(ItemNoCarrinhoDto item) {
        return ItemNoCarrinho.builder()
                .id(item.getId())
                .nome(item.getNome())
                .quantidade(item.getQuantidade())
                .carrinhoDeCompra(CarrinhoDeCompra.builder().id(item.getCarrinhoDeCompra()).build())
                .valor(item.getValor())
                .promocao(item.getPromocao())
                .createdBy(item.getCreatedBy())
                .createdDate(item.getCreatedDate())
                .modifiedBy(item.getModifiedBy())
                .modifiedDate(item.getModifiedDate())
                .build();
    }
}
