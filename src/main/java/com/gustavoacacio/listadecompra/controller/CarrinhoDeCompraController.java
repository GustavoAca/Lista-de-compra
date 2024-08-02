package com.gustavoacacio.listadecompra.controller;

import com.gustavoacacio.listadecompra.domain.model.dto.CarrinhoDeCompraDto;
import com.gustavoacacio.listadecompra.domain.service.carrinhodecompra.CarrinhoDeCompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carrinho-de-compra")
public class CarrinhoDeCompraController {

    private final CarrinhoDeCompraService carrinhoDeCompraService;

    public CarrinhoDeCompraController(CarrinhoDeCompraService carrinhoDeCompraService) {
        this.carrinhoDeCompraService = carrinhoDeCompraService;
    }

    @PostMapping
    public ResponseEntity<CarrinhoDeCompraDto> salvar(@RequestBody CarrinhoDeCompraDto carrinhoDeCompraDto) {
        return ResponseEntity.ok(carrinhoDeCompraService.salvar(carrinhoDeCompraDto));
    }

    @GetMapping("/mais-recente")
    public ResponseEntity<Optional<CarrinhoDeCompraDto>> getUltimoCarrinho() {
        return ResponseEntity.ok(carrinhoDeCompraService.getUltimoCarrinho());
    }
}
