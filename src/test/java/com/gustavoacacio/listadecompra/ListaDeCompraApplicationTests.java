package com.gustavoacacio.listadecompra;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.NestedTestConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = ListaDeCompraApplication.class)
@NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.OVERRIDE)
@ExtendWith(SpringExtension.class)
@WithMockUser(username = "gustavo.acacio@gmail.com", roles = {"SCOPE_ADMIN"})
public abstract class ListaDeCompraApplicationTests {

    static {
        System.setProperty("spring.profiles.active", "test");
        System.setProperty("jwt.private.key", "classpath:app.key");
    }
}
