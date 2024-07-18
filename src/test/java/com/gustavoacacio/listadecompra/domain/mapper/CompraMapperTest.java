package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.controller.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompraMapperTest extends ListaDeCompraApplicationTests {
    @Autowired
    private CompraMapper compraMapper;

    @Nested
    class Dado_uma_entidade extends ListaDeCompraApplicationTests {

        private Compra compra;

        @BeforeEach
        void setup() {
            compra = Compra.builder()
                    .id(1L)
                    .items(List.of(Item.builder()
                            .compra(Compra.builder().id(1L).build())
                            .id(1L)
                            .build()))
                    .build();
        }

        @Nested
        class Quando_transformar_em_dto extends ListaDeCompraApplicationTests {
            private CompraDto compraDto;

            @BeforeEach
            void setup() {
                compraDto = compraMapper.toDto(compra);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertEquals(1L, compraDto.id());
                assertEquals(1L, compraDto.itemDtos().size());
            }
        }
    }

    @Nested
    class Dado_um_dto extends ListaDeCompraApplicationTests {

        private CompraDto compraDto;

        @BeforeEach
        void setup() {
            compraDto = CompraDto.builder()
                    .id(1L)
                    .itemDtos(List.of(ItemDto.builder()
                            .compraId(1L)
                            .id(1L)
                            .build()))
                    .build();
        }

        @Nested
        class Quando_transformar_em_dto extends ListaDeCompraApplicationTests {
            private Compra compra;

            @BeforeEach
            void setup() {
                compra = compraMapper.toEntity(compraDto);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertEquals(1L, compra.getId());
                assertEquals(1L, compra.getItems().size());
            }
        }
    }
}