package com.gustavoacacio.listadecompra.domain.service.item;

import com.gustavoacacio.listadecompra.core.service.JpaServiceImpl;
import com.gustavoacacio.listadecompra.domain.mapper.ItemMapper;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.repository.jpa.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends JpaServiceImpl<Item, Long, ItemRepository> implements ItemService {

    private final ItemMapper itemMapper;

    protected ItemServiceImpl(ItemRepository repo,
                              ItemMapper itemMapper) {
        super(repo);
        this.itemMapper = itemMapper;
    }

    public ItemDto atualizar(ItemDto itemDto) {
        return itemMapper.toDto(super.salvar(itemMapper.toEntity(itemDto)));
    }

    public Page<ItemDto> listarPorNome(String nome, Pageable pageable) {
        Page<Item> itemPage = repo.findAllByNomeContainingIgnoreCase(nome, pageable);

        List<ItemDto> itemDtoList = itemPage.getContent()
                .stream()
                .map(itemMapper::toDto)
                .toList();

        return new PageImpl<>(itemDtoList, pageable, itemPage.getTotalElements());
    }
}
