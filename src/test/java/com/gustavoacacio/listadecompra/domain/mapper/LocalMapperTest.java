package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.domain.model.Local;
import com.gustavoacacio.listadecompra.domain.model.dto.LocalDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocalMapperTest extends ListaDeCompraApplicationTests {

    @Autowired
    private LocalMapper localMapper;

    @Nested
    class Dado_uma_entidade extends ListaDeCompraApplicationTests {
        private static UUID uuid = UUID.randomUUID();
        private Local local;

        @BeforeEach
        void setup() {
            local = Local.builder()
                    .id(uuid)
                    .nome("Local")
                    .build();

        }

        @Nested
        class Quando_transformar_em_dto extends ListaDeCompraApplicationTests {
            private LocalDto localDto;

            @BeforeEach
            void setup() {
                localDto = localMapper.toDto(local);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertEquals(uuid, localDto.getId());
                assertEquals("Local", localDto.getNome());
            }
        }
    }

    @Nested
    class Dado_um_dto extends ListaDeCompraApplicationTests {
        private static UUID uuid = UUID.randomUUID();
        private LocalDto dto;

        @BeforeEach
        void setup() {
            dto = LocalDto.builder()
                    .id(uuid)
                    .nome("Local")
                    .build();
        }

        @Nested
        class Quando_transformar_em_entidade extends ListaDeCompraApplicationTests {
            private Local local;

            @BeforeEach
            void setup() {
                local = localMapper.toEntity(dto);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertEquals(uuid, local.getId());
                assertEquals("Local", local.getNome());
            }
        }
    }


}