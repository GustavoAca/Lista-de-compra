package com.gustavoacacio.listadecompra.controller;

import com.gustavoacacio.listadecompra.controller.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.service.compra.CompraService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
