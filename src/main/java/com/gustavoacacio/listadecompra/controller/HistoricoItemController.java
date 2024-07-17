package com.gustavoacacio.listadecompra.controller;

import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.service.historico.HistoricoItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historicoitems")
public class HistoricoItemController {

    private final HistoricoItemService historicoItemService;

    public HistoricoItemController(HistoricoItemService historicoItemService) {
        this.historicoItemService = historicoItemService;
    }

    @GetMapping("/compra/{compraId}")
    public ResponseEntity<Page<HistoricoItemDto>> listarPorCompraId(@PathVariable Long compraId,
                                                                    @PageableDefault(page = 0, size = 20) Pageable pageable) {
        return ResponseEntity.ok(historicoItemService.listarPorCompraId(compraId, pageable));
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity<Page<HistoricoItemDto>> listarPorItemID(@PathVariable Long itemId,
                                                                  @PageableDefault(page = 0, size = 20) Pageable pageable) {
        return ResponseEntity.ok(historicoItemService.listarPorItemId(itemId, pageable));
    }
}
