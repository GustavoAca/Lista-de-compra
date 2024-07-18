package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class HistoricoItemMapperTest extends ListaDeCompraApplicationTests {

    @Autowired
    private HistoricoItemMapper historicoItemMapper;

    @Nested
    class Dado_uma_entidade extends ListaDeCompraApplicationTests {
        private HistoricoItem historicoItem;

        @BeforeEach
        void setup() {
            historicoItem = HistoricoItem.builder()
                    .itemId(1L)
                    .valorItem(BigDecimal.ONE)
                    .compraId(1L)
                    .build();
        }

        @Nested
        class Quando_transformar_em_dto extends ListaDeCompraApplicationTests {
            private HistoricoItemDto historicoItemDto;

            @BeforeEach
            void setup() {
                historicoItemDto = historicoItemMapper.toDto(historicoItem);
            }

            @Test
            void Deve_ter_sucesso() {
                assertNotNull(historicoItemDto);
                assertEquals(1L, historicoItemDto.getCompraId());
                assertEquals(1L, historicoItemDto.getItemId());
                assertEquals(BigDecimal.ONE, historicoItemDto.getValorItem());
            }
        }
    }

    @Nested
    class Dado_um_dto extends ListaDeCompraApplicationTests {
        private HistoricoItemDto historicoItemDto;

        @BeforeEach
        void setup() {
            historicoItemDto = HistoricoItemDto.builder()
                    .itemId(1L)
                    .valorItem(BigDecimal.ONE)
                    .compraId(1L)
                    .build();
        }

        @Nested
        class Quando_transformar_em_entidade extends ListaDeCompraApplicationTests {
            private HistoricoItem historicoItem;

            @BeforeEach
            void setup() {
                historicoItem = historicoItemMapper.toEntity(historicoItemDto);
            }

            @Test
            void Deve_ter_sucesso() {
                assertNotNull(historicoItem);
                assertEquals(1L, historicoItem.getCompraId());
                assertEquals(1L, historicoItem.getItemId());
                assertEquals(BigDecimal.ONE, historicoItem.getValorItem());
            }
        }
    }
}