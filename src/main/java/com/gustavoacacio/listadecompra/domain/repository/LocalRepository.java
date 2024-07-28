package com.gustavoacacio.listadecompra.domain.repository;

import com.gustavoacacio.listadecompra.core.repository.BaseRepository;
import com.gustavoacacio.listadecompra.domain.model.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocalRepository extends JpaRepository<Local, UUID>, BaseRepository<Local, UUID> {

    Optional<Local> findByNome(String username);
}
