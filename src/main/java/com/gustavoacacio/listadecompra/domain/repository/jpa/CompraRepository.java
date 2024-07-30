package com.gustavoacacio.listadecompra.domain.repository.jpa;


import com.gustavoacacio.listadecompra.core.repository.jpa.JpaRepository;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends org.springframework.data.jpa.repository.JpaRepository<Compra, Long>, JpaRepository<Compra, Long> {
}
