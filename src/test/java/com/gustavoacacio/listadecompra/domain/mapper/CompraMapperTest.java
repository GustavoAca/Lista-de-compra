package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.Local;
import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.service.local.LocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompraMapperTest extends ListaDeCompraApplicationTests {
    @Autowired
    private CompraMapper compraMapper;

    @Autowired
    private LocalService localService;

    @Nested
    class Dado_uma_entidade extends ListaDeCompraApplicationTests {

        private Compra compra;

        @BeforeEach
        void setup() {
            var local = Local.builder()
                    .nome("Local")
                    .build();
            local = localService.salvar(local);

            compra = Compra.builder()
                    .id(1L)
                    .items(List.of(Item.builder()
                            .compra(Compra.builder().id(1L).build())
                            .id(1L)
                            .local(local)
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
                assertEquals(1L, compraDto.getId());
                assertEquals(1L, compraDto.getItems().size());
            }
        }
    }

    @Nested
    class Dado_um_dto extends ListaDeCompraApplicationTests {

        private CompraDto compraDto;

        @BeforeEach
        void setup() {
            var local = Local.builder()
                    .nome("Local")
                    .build();
            local = localService.salvar(local);
            compraDto = CompraDto.builder()
                    .id(1L)
                    .items(List.of(ItemDto.builder()
                            .compraId(1L)
                            .id(1L)
                            .localId(local.getId())
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