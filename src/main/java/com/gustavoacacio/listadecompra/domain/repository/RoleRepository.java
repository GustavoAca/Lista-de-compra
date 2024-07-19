package com.gustavoacacio.listadecompra.domain.repository;

import com.gustavoacacio.listadecompra.core.repository.BaseRepository;
import com.gustavoacacio.listadecompra.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>, BaseRepository<Role, Long> {
    Role findByName(String name);
}
