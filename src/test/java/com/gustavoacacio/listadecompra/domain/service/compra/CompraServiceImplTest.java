package com.gustavoacacio.listadecompra.domain.service.compra;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.mapper.CompraMapper;
import com.gustavoacacio.listadecompra.domain.mapper.ItemMapper;
import com.gustavoacacio.listadecompra.domain.model.Local;
import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.repository.jpa.CompraRepository;
import com.gustavoacacio.listadecompra.domain.service.item.ItemService;
import com.gustavoacacio.listadecompra.domain.service.local.LocalService;
import com.gustavoacacio.listadecompra.producer.ItemProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CompraServiceImplTest extends ListaDeCompraApplicationTests {

    private CompraService compraService;

    @Mock
    private ItemProducer itemProducer;

    @Autowired
    private ItemService itemService;

    @Autowired
    private CompraMapper compraMapper;

    @Autowired
    private CompraRepository repository;

    @Autowired
    private LocalService localService;

    @Autowired
    private ItemMapper itemMapper;

    @BeforeEach
    void setup() {
        compraService = new CompraServiceImpl(repository, compraMapper, itemService, itemProducer, itemMapper);
    }

    @Nested
    class Dado_uma_compra_com_itens extends ListaDeCompraApplicationTests {
        private CompraDto compraDto;

        @BeforeEach
        void setup() {
            var local = Local.builder()
                    .nome("Local")
                    .build();
            localService.salvar(local);

            ItemDto item1 = ItemDto.builder()
                    .id(1L)
                    .valor(BigDecimal.valueOf(10.00))
                    .quantidade(1L)
                    .localId(local.getId())
                    .nome("Arroz").build();
            ItemDto item2 = ItemDto.builder()
                    .id(2L)
                    .valor(BigDecimal.valueOf(10.00))
                    .quantidade(1L)
                    .localId(local.getId())
                    .nome("Feijão")
                    .build();
            itemService.salvar(itemMapper.toEntity(item1));
            itemService.salvar(itemMapper.toEntity(item2));
            compraDto = CompraDto.builder()
                    .items(List.of(item1, item2))
                    .build();
        }

        @Nested
        class Quando_salvar extends ListaDeCompraApplicationTests {
            private CompraDto compraSalva;

            @BeforeEach
            void setup() {
                compraSalva = compraService.salvar(compraDto);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertNotNull(compraSalva);
                assertEquals(2L, compraSalva.getItems().size());
                assertEquals(new BigDecimal("20.00"), compraSalva.getValorTotal());
            }
        }
    }
}