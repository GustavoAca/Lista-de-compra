package com.gustavoacacio.listadecompra;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest
class ListaDeCompraApplicationTests {

	@Test
	void contextLoads() {
	}

	static {
		System.setProperty("spring.profiles.active", "test");
	}
}
