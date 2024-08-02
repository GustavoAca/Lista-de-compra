package com.gustavoacacio.listadecompra.domain.repository.jpa;

import com.gustavoacacio.listadecompra.core.repository.jpa.JpaRepository;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoDeCompraRepository extends JpaRepository<CarrinhoDeCompra, Long> {
}
