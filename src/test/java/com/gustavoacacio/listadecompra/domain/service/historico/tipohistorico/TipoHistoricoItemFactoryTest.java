package com.gustavoacacio.listadecompra.domain.service.historico.tipohistorico;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

class TipoHistoricoItemFactoryTest extends ListaDeCompraApplicationTests {

    @Autowired
    private TipoHistoricoItemFactory tipoHistoricoItemFactory;

    @Nested
    class Dado_um_item extends ListaDeCompraApplicationTests {
        private HistoricoItemDto historicoItemDto;

        @BeforeEach
        void setup() {
            ItemDto itemDto = ItemDto.builder()
                    .id(10001L)
                    .localId(UUID.randomUUID())
                    .valor(BigDecimal.ONE)
                    .build();
            CompraDto compraDto = CompraDto.builder()
                    .items(List.of(itemDto))
                    .id(10001L)
                    .build();
            historicoItemDto = HistoricoItemDto.builder()
                    .compraId(compraDto.getId())
                    .localId(itemDto.getLocalId())
                    .valorItem(itemDto.getValor())
                    .itemId(itemDto.getId())
                    .build();
        }

        @Nested
        class Quando_fabricar_historico extends ListaDeCompraApplicationTests {
            private HistoricoItem historicoItem;

            @BeforeEach
            void setup() {
                historicoItem = tipoHistoricoItemFactory.fabricar(historicoItemDto);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                Assertions.assertNotNull(historicoItem);
            }
        }
    }

}