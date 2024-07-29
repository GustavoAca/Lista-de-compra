package com.gustavoacacio.listadecompra.domain.repository.jpa;

import com.gustavoacacio.listadecompra.core.repository.jpa.JpaRepository;
import com.gustavoacacio.listadecompra.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<User, UUID>, JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);
}
