package com.gustavoacacio.listadecompra.domain.service.role;

import com.gustavoacacio.listadecompra.core.service.jpa.JpaService;
import com.gustavoacacio.listadecompra.domain.model.Role;

public interface RoleService extends JpaService<Role, Long> {
    Role findByName(String name);
}
