package com.gustavoacacio.listadecompra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.gustavoacacio.listadecompra.domain.repository")
public class ListaDeCompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListaDeCompraApplication.class, args);
	}
}
