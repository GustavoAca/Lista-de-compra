package com.gustavoacacio.listadecompra.domain.repository.jpa;

import com.gustavoacacio.listadecompra.core.repository.jpa.JpaRepository;
import com.gustavoacacio.listadecompra.domain.model.Local;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocalRepository extends org.springframework.data.jpa.repository.JpaRepository<Local, UUID>, JpaRepository<Local, UUID> {

    Optional<Local> findByNome(String username);
}
