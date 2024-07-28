package com.gustavoacacio.listadecompra.controller;

import com.gustavoacacio.listadecompra.domain.model.dto.LocalDto;
import com.gustavoacacio.listadecompra.domain.service.local.LocalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locais")
public class LocalController {

    private final LocalService localService;

    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @PostMapping
    public ResponseEntity<LocalDto> cadastrar(@RequestBody LocalDto localDto) {
        return ResponseEntity.ok(localService.cadastrar(localDto));
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<LocalDto>> listarPaginado(@PageableDefault(page = 0, size = 20) Pageable pageable) {
        return ResponseEntity.ok(localService.listarPaginado(pageable));
    }
}