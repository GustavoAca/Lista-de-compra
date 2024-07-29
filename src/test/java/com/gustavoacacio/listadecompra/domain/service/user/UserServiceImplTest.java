package com.gustavoacacio.listadecompra.domain.service.user;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.controller.dto.CreateUserDto;
import com.gustavoacacio.listadecompra.domain.model.User;
import com.gustavoacacio.listadecompra.exception.UsuarioNaoCadastradoException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceImplTest extends ListaDeCompraApplicationTests {

    @Autowired
    private UserService userService;

    @Nested
    class Dado_um_novo_usuario extends ListaDeCompraApplicationTests {
        private String userTemp = "userTemp@gmail.com";
        private CreateUserDto createUserDto;

        @BeforeEach
        void setup() {
            createUserDto = new CreateUserDto(userTemp, "12345");
        }

        @Nested
        class Quando_cadastrar extends ListaDeCompraApplicationTests {
            private User user;

            @BeforeEach
            void setup() {
                userService.cadastrarUsuario(createUserDto);
                user = userService.findByUsername(createUserDto.username())
                        .orElseThrow(() -> new UsuarioNaoCadastradoException(createUserDto.username()));
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertEquals(userTemp, user.getUsername());
            }
        }
    }
}