package com.gustavoacacio.listadecompra.domain.service.historico.tipohistorico;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.UUID;

class TipoHistoricoItemFactoryTest extends ListaDeCompraApplicationTests {

    @Autowired
    private TipoHistoricoItemFactory tipoHistoricoItemFactory;

    @Nested
    class Dado_um_item extends ListaDeCompraApplicationTests {
        private ItemDto itemDto;

        @BeforeEach
        void setup() {
            itemDto = ItemDto.builder()
                    .id(1L)
                    .localId(UUID.randomUUID())
                    .compraId(1L)
                    .valor(BigDecimal.ONE)
                    .build();

        }

        @Nested
        class Quando_fabricar_historico extends ListaDeCompraApplicationTests {
            private HistoricoItem historicoItem;

            @BeforeEach
            void setup() {
                historicoItem = tipoHistoricoItemFactory.fabricar(itemDto);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                Assertions.assertNotNull(historicoItem);
            }
        }
    }

}