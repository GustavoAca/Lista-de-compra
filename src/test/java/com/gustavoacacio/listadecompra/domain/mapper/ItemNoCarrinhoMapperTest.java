package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.model.ItemNoCarrinho;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import com.gustavoacacio.listadecompra.domain.model.dto.ItemNoCarrinhoDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemNoCarrinhoMapperTest extends ListaDeCompraApplicationTests {

    private static final Long itemId = 1L;
    private static final String nome = "Item";
    private static final Long quantidade = 2L;
    private static final Long carrinhoDeCompraId = 1L;
    private static final BigDecimal valor = BigDecimal.ONE;
    private static final Boolean promocao = Boolean.FALSE;
    private static final String created = "gustavo";
    private static final LocalDateTime now = LocalDateTime.now();
    @Autowired
    private ItemNoCarrinhoMapper itemNoCarrinhoMapper;

    @Nested
    class Dado_entidade extends ListaDeCompraApplicationTests {
        private ItemNoCarrinho itemNoCarrinho;

        @BeforeEach
        void setup() {
            itemNoCarrinho = ItemNoCarrinho.builder()
                    .id(itemId)
                    .nome(nome)
                    .quantidade(quantidade)
                    .carrinhoDeCompra(CarrinhoDeCompra.builder().id(carrinhoDeCompraId).build())
                    .valor(valor)
                    .promocao(promocao)
                    .createdBy(created)
                    .createdDate(now)
                    .modifiedBy(created)
                    .modifiedDate(now)
                    .build();
        }

        @Nested
        class Quando_converter_para_dto extends ListaDeCompraApplicationTests {
            private ItemNoCarrinhoDto itemNoCarrinhoDto;

            @BeforeEach
            void setup() {
                itemNoCarrinhoDto = itemNoCarrinhoMapper.toDto(itemNoCarrinho);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertEquals(itemId, itemNoCarrinhoDto.getId());
                assertEquals(nome, itemNoCarrinhoDto.getNome());
                assertEquals(quantidade, itemNoCarrinhoDto.getQuantidade());
                assertEquals(carrinhoDeCompraId, itemNoCarrinhoDto.getCarrinhoDeCompra());
                assertEquals(valor, itemNoCarrinhoDto.getValor());
                assertEquals(promocao, itemNoCarrinhoDto.getPromocao());
                assertEquals(created, itemNoCarrinhoDto.getCreatedBy());
                assertEquals(created, itemNoCarrinhoDto.getModifiedBy());
                assertEquals(now, itemNoCarrinhoDto.getCreatedDate());
                assertEquals(now, itemNoCarrinhoDto.getModifiedDate());
            }
        }
    }

    @Nested
    class Dado_dto extends ListaDeCompraApplicationTests {
        private ItemNoCarrinhoDto itemNoCarrinhoDto;

        @BeforeEach
        void setup() {
            itemNoCarrinhoDto = ItemNoCarrinhoDto.builder()
                    .id(itemId)
                    .nome(nome)
                    .quantidade(quantidade)
                    .carrinhoDeCompra(carrinhoDeCompraId)
                    .valor(valor)
                    .promocao(promocao)
                    .createdBy(created)
                    .createdDate(now)
                    .modifiedBy(created)
                    .modifiedDate(now)
                    .build();
        }

        @Nested
        class Quando_converter_para_entidade extends ListaDeCompraApplicationTests {
            private ItemNoCarrinho itemNoCarrinho;

            @BeforeEach
            void setup() {
                itemNoCarrinho = itemNoCarrinhoMapper.toEntity(itemNoCarrinhoDto);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertEquals(itemId, itemNoCarrinho.getId());
                assertEquals(nome, itemNoCarrinho.getNome());
                assertEquals(quantidade, itemNoCarrinho.getQuantidade());
                assertEquals(carrinhoDeCompraId, itemNoCarrinho.getCarrinhoDeCompra().getId());
                assertEquals(valor, itemNoCarrinho.getValor());
                assertEquals(promocao, itemNoCarrinho.getPromocao());
                assertEquals(created, itemNoCarrinho.getCreatedBy());
                assertEquals(created, itemNoCarrinho.getModifiedBy());
                assertEquals(now, itemNoCarrinho.getCreatedDate());
                assertEquals(now, itemNoCarrinho.getModifiedDate());
            }
        }
    }

}