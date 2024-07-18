package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemMapperTest extends ListaDeCompraApplicationTests {

    @Autowired
    private ItemMapper itemMapper;

    @Nested
    class Dado_uma_entidade extends ListaDeCompraApplicationTests {
        private Item item;

        @BeforeEach
        void setup() {
            item = Item.builder()
                    .id(1L)
                    .nome("Arroz")
                    .valor(BigDecimal.ONE)
                    .compra(Compra.builder()
                            .id(1L)
                            .build())
                    .quantidade(1L)
                    .build();
        }

        @Nested
        class Quando_transformar_em_dto extends ListaDeCompraApplicationTests {
            private ItemDto itemDto;

            @BeforeEach
            void setup() {
                itemDto = itemMapper.toDto(item);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertEquals(1L, itemDto.getId());
                assertEquals("Arroz", itemDto.getNome());
                assertEquals(BigDecimal.ONE, itemDto.getValor());
                assertEquals(1L, itemDto.getCompraId());
                assertEquals(1L, itemDto.getQuantidade());
            }
        }
    }

    @Nested
    class Dado_um_dto extends ListaDeCompraApplicationTests {
        private ItemDto dto;

        @BeforeEach
        void setup() {
            dto = ItemDto.builder()
                    .id(1L)
                    .nome("Arroz")
                    .valor(BigDecimal.ONE)
                    .compraId(1L)
                    .quantidade(1L)
                    .build();
        }

        @Nested
        class Quando_transformar_em_entidade extends ListaDeCompraApplicationTests {
            private Item item;

            @BeforeEach
            void setup() {
                item = itemMapper.toEntity(dto);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertEquals(1L, item.getId());
                assertEquals("Arroz", item.getNome());
                assertEquals(BigDecimal.ONE, item.getValor());
                assertEquals(1L, item.getCompra().getId());
                assertEquals(1L, item.getQuantidade());
            }
        }
    }
}