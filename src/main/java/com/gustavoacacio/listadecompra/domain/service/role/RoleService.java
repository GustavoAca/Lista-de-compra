package com.gustavoacacio.listadecompra.domain.service.role;

import com.gustavoacacio.listadecompra.core.service.BaseService;
import com.gustavoacacio.listadecompra.domain.model.Role;

public interface RoleService extends BaseService<Role, Long> {
    Role findByName(String name);
}
