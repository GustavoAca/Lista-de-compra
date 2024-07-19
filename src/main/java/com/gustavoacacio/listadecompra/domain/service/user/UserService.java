package com.gustavoacacio.listadecompra.domain.service.user;

import com.gustavoacacio.listadecompra.controller.dto.CreateUserDto;
import com.gustavoacacio.listadecompra.core.service.BaseService;
import com.gustavoacacio.listadecompra.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService extends BaseService<User, UUID> {

    Optional<User> findByUsername(String username);

    void cadastrarUsuario(CreateUserDto createUserDto);
}
