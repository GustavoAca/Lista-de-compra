package com.gustavoacacio.listadecompra;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.NestedTestConfiguration;

@SpringBootTest(classes = ListaDeCompraApplication.class)
@NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.OVERRIDE)
public abstract class ListaDeCompraApplicationTests {

	static {
		System.setProperty("spring.profiles.active", "test");
	}
}
