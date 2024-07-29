package com.gustavoacacio.listadecompra;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.NestedTestConfiguration;

@SpringBootTest(classes = ListaDeCompraApplication.class)
@NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.OVERRIDE)
@WithMockUser(username = "gustavo.acacio@gmail.com", roles = {"SCOPE_ADMIN"})
public abstract class ListaDeCompraApplicationTests {

    static {
        System.setProperty("spring.profiles.active", "test");
        System.setProperty("jwt.public.key", "classpath:app.pub");
        System.setProperty("jwt.private.key", "classpath:app.key");
    }
}
