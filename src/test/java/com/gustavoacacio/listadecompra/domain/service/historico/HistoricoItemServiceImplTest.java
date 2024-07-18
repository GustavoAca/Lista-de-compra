package com.gustavoacacio.listadecompra.domain.service.historico;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.mapper.HistoricoItemMapper;
import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.Random;

class HistoricoItemServiceImplTest extends ListaDeCompraApplicationTests {

    @Autowired
    private HistoricoItemService historicoItemService;

    @Autowired
    private HistoricoItemMapper historicoItemMapper;

    @Nested
    public class Dado_um_historico_de_item extends ListaDeCompraApplicationTests {
        private HistoricoItem historicoItem;
        private Page<HistoricoItemDto> historicoItemDtoPage;

        @BeforeEach
        void setup() {
            historicoItem = HistoricoItem.builder()
                    .itemId(criarLong())
                    .compraId(criarLong())
                    .valorItem(BigDecimal.ONE)
                    .build();

            historicoItem = historicoItemService.salvar(historicoItem);
        }

        @Nested
        class Quando_buscar_por_compra extends ListaDeCompraApplicationTests {

            @BeforeEach
            void setup() {
                historicoItemDtoPage = historicoItemService.listarPorCompraId(historicoItem.getCompraId(), Pageable.unpaged());
            }

            @Test
            void Entao_deve_encontrar() {
                Assertions.assertEquals(1L, historicoItemDtoPage.getTotalElements());
            }
        }

        @Nested
        class Quando_buscar_por_item extends ListaDeCompraApplicationTests {

            @BeforeEach
            void setup() {
                historicoItemDtoPage = historicoItemService.listarPorItemId(historicoItem.getItemId(), Pageable.unpaged());
            }

            @Test
            void Entao_deve_encontrar() {
                Assertions.assertEquals(1L, historicoItemDtoPage.getTotalElements());
            }
        }
    }

    private Long criarLong() {
        Random random = new Random();
        long randomLong = 1 + (long) (random.nextDouble() * (100 - 1));
        return Long.valueOf(randomLong);
    }
}