package com.gustavoacacio.listadecompra.domain.service.item;

import com.gustavoacacio.listadecompra.core.service.BaseService;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemService extends BaseService<Item, Long> {

    ItemDto atualizar(ItemDto itemDto);

    Page<ItemDto> listarPorNome(String nome, Pageable pageable);
}
