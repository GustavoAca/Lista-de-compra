package com.gustavoacacio.listadecompra.domain.repository.jpa;

import com.gustavoacacio.listadecompra.core.repository.jpa.JpaRepository;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarrinhoDeCompraRepository extends JpaRepository<CarrinhoDeCompra, Long> {

    @Query("SELECT c FROM CarrinhoDeCompra c " +
            "WHERE c.usuario = :user")
    Optional<CarrinhoDeCompra> findCarrinhoPorUser(@Param("user") String user);

}
