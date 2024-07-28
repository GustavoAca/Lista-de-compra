package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.Local;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.service.local.LocalService;
import com.gustavoacacio.listadecompra.exception.RegistroNaoEncontradoException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ItemMapper {

    private final LocalService localService;

    public ItemMapper(LocalService localService) {
        this.localService = localService;
    }

    public ItemDto toDto(Item item) {
        return ItemDto.builder()
                .id(item.getId())
                .nome(item.getNome())
                .quantidade(item.getQuantidade())
                .valor(item.getValor())
                .localId(toLocalDto(item.getLocal()))
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
                .local(toLocalEntity(item.getLocalId()))
                .quantidade(item.getQuantidade())
                .compra(Compra.builder().id(item.getCompraId()).build())
                .valor(item.getValor())
                .createdBy(item.getCreatedBy())
                .createdDate(item.getCreatedDate())
                .modifiedBy(item.getModifiedBy())
                .modifiedDate(item.getModifiedDate())
                .build();
    }

    private Local toLocalEntity(UUID localId) {
        var local = localService.buscarPorId(localId)
                .orElseThrow(() -> new RegistroNaoEncontradoException(localId, Local.class.getName()));
        return Local.builder()
                .id(localId)
                .nome(local.getNome())
                .createdDate(local.getCreatedDate())
                .createdBy(local.getCreatedBy())
                .modifiedDate(local.getModifiedDate())
                .modifiedBy(local.getModifiedBy())
                .build();
    }

    private UUID toLocalDto(Local local) {
        return local.getId();
    }
}
