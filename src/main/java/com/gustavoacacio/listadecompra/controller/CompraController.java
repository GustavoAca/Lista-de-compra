package com.gustavoacacio.listadecompra.controller;

import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.service.compra.CompraService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {
    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<CompraDto> criar(@RequestBody @Valid CompraDto compraDto) {
        return ResponseEntity.ok(compraService.salvar(compraDto));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<CompraDto>> listar(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        return ResponseEntity.ok(compraService.listar(pageable));
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        compraService.deletar(id);
    }


}
