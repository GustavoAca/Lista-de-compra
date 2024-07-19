package com.gustavoacacio.listadecompra.domain.service.item;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.mapper.CompraMapper;
import com.gustavoacacio.listadecompra.domain.model.Item;
import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import com.gustavoacacio.listadecompra.domain.repository.CompraRepository;
import com.gustavoacacio.listadecompra.domain.service.compra.CompraService;
import com.gustavoacacio.listadecompra.domain.service.compra.CompraServiceImpl;
import com.gustavoacacio.listadecompra.exception.RegistroNaoEncontradoException;
import com.gustavoacacio.listadecompra.producer.ItemProducer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

class ItemServiceImplTest extends ListaDeCompraApplicationTests {

    @Autowired
    private ItemService itemService;

    private CompraService compraService;

    @Mock
    private ItemProducer itemProducer;


    @Autowired
    private CompraMapper compraMapper;

    @Autowired
    private CompraRepository repository;

    @BeforeEach
    void setup() {
        compraService = new CompraServiceImpl(repository, compraMapper, itemService, itemProducer);
    }


    @Nested
    class Dado_um_item_salvo extends ListaDeCompraApplicationTests {
        private CompraDto compraDto;
        private Page<ItemDto> itemDtoPage;
        private final String nome = "Abobora";

        @BeforeEach
        void setup() {
            compraDto = CompraDto.builder()
                    .items(List.of(ItemDto.builder()
                            .nome(nome)
                            .valor(BigDecimal.ONE)
                            .quantidade(1L)
                            .build()))
                    .build();
            compraDto = compraService.salvar(compraDto);
        }

        @Nested
        class Quando_buscar_por_nome extends ListaDeCompraApplicationTests {

            @BeforeEach
            void setup() {
                itemDtoPage = itemService.listarPorNome("Abobo", Pageable.unpaged());
            }

            @Test
            void Entao_deve_ter_sucesso() {
                Assertions.assertNotEquals(0L, itemDtoPage.getTotalElements());
            }
        }

        @Nested
        class Quando_buscar_todos extends ListaDeCompraApplicationTests {
            private Page<Item> itemPage;

            @BeforeEach
            void setup() {
                itemPage = itemService.listarPagina(Pageable.unpaged());
            }

            @Test
            void Entao_deve_ter_sucesso() {
                Assertions.assertNotEquals(0L, itemPage.getTotalElements());
            }
        }

        @Nested
        class Quando_buscar_por_id extends ListaDeCompraApplicationTests {
            private Item item;

            @BeforeEach
            void setup() {
                item = itemService.buscarPorId(compraDto.getItems().get(0).getId())
                        .orElseThrow(() -> new RegistroNaoEncontradoException(compraDto.getItems().get(0).getId(), Item.class.getName()));
            }

            @Test
            void Entao_deve_ter_sucesso() {
                Assertions.assertEquals(1L, item.getQuantidade());
            }
        }
    }
}