package com.gustavoacacio.listadecompra.domain.service;

import com.gustavoacacio.listadecompra.ListaDeCompraApplicationTests;
import com.gustavoacacio.listadecompra.controller.dto.LoginRequest;
import com.gustavoacacio.listadecompra.controller.dto.LoginResponse;
import com.gustavoacacio.listadecompra.exception.CredencialException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TokenComponentTest extends ListaDeCompraApplicationTests {

    private static final String usuarioCorreto = "gustavo.acacio@gmail.com";
    private static final String usuarioIncorreto = "gustavo@gmail.com";
    private static final String senhaCorreta = "1234";
    private static final String senhaIncorreta = "12345";
    private static final String mensagemDeErro = "Usuário ou senha inválidos";
    @Autowired
    private TokenComponent tokenComponent;

    @Nested
    class Dado_usuario_existente extends ListaDeCompraApplicationTests {
        private LoginRequest loginRequest;

        @BeforeEach
        void setup() {
            loginRequest = new LoginRequest(usuarioCorreto, senhaCorreta);
        }

        @Nested
        class Quando_logar extends ListaDeCompraApplicationTests {
            private LoginResponse loginResponse;

            @BeforeEach
            void setup() {
                loginResponse = tokenComponent.login(loginRequest);
            }

            @Test
            void Entao_deve_ter_sucesso() {
                assertNotNull(loginResponse);
            }
        }
    }

    @Nested
    class Dado_usuario_existente_com_usuario_errado extends ListaDeCompraApplicationTests {
        private LoginRequest loginRequest;

        @BeforeEach
        void setup() {
            loginRequest = new LoginRequest(usuarioIncorreto, senhaCorreta);
        }

        @Nested
        class Quando_logar extends ListaDeCompraApplicationTests {
            private CredencialException credencialException;

            @BeforeEach
            void setup() {
                try {
                    tokenComponent.login(loginRequest);
                } catch (CredencialException e) {
                    credencialException = e;
                }
            }

            @Test
            void Entao_deve_ter_erro() {
                assertNotNull(credencialException);
                assertEquals(mensagemDeErro, credencialException.toProblemDetail().getDetail());
            }
        }
    }

    @Nested
    class Dado_usuario_existente_com_senha_errada extends ListaDeCompraApplicationTests {
        private LoginRequest loginRequest;

        @BeforeEach
        void setup() {
            loginRequest = new LoginRequest(usuarioCorreto, senhaIncorreta);
        }

        @Nested
        class Quando_logar extends ListaDeCompraApplicationTests {
            private CredencialException credencialException;

            @BeforeEach
            void setup() {
                try {
                    tokenComponent.login(loginRequest);
                } catch (CredencialException e) {
                    credencialException = e;
                }
            }

            @Test
            void Entao_deve_ter_erro() {
                assertNotNull(credencialException);
                assertEquals(mensagemDeErro, credencialException.toProblemDetail().getDetail());
            }
        }
    }
}