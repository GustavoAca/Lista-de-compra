package com.gustavoacacio.listadecompra.domain.service.role;

import com.gustavoacacio.listadecompra.core.service.JpaServiceImpl;
import com.gustavoacacio.listadecompra.domain.model.Role;
import com.gustavoacacio.listadecompra.domain.repository.jpa.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends JpaServiceImpl<Role, Long, RoleRepository> implements RoleService {

    protected RoleServiceImpl(RoleRepository repo) {
        super(repo);
    }

    @Override
    public Role findByName(String name) {
        return repo.findByName(name);
    }
}
