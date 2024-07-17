package com.gustavoacacio.listadecompra.controller;

import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.service.item.ItemService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itens")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PutMapping
    public ResponseEntity<ItemDto> atualizar(@RequestBody @Valid ItemDto itemDto) {
        return ResponseEntity.ok(itemService.salvar(itemDto));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Page<ItemDto>> listarPorNome(@PathVariable String nome, @PageableDefault(page = 0, size = 5) Pageable pageable) {
        return ResponseEntity.ok(itemService.listarPorNome(nome, pageable));
    }
}
