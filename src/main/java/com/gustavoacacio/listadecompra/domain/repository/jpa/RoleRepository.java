package com.gustavoacacio.listadecompra.domain.repository.jpa;

import com.gustavoacacio.listadecompra.core.repository.jpa.JpaRepository;
import com.gustavoacacio.listadecompra.domain.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends org.springframework.data.jpa.repository.JpaRepository<Role, Long>, JpaRepository<Role, Long> {
    Role findByName(String name);
}
