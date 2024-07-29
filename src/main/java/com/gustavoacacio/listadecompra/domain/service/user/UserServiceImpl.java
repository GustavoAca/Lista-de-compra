package com.gustavoacacio.listadecompra.domain.service.user;

import com.gustavoacacio.listadecompra.controller.dto.CreateUserDto;
import com.gustavoacacio.listadecompra.core.service.JpaServiceImpl;
import com.gustavoacacio.listadecompra.domain.model.Role;
import com.gustavoacacio.listadecompra.domain.model.User;
import com.gustavoacacio.listadecompra.domain.repository.jpa.UserRepository;
import com.gustavoacacio.listadecompra.domain.service.role.RoleService;
import com.gustavoacacio.listadecompra.exception.UsuarioJaCadastradoException;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserServiceImpl extends JpaServiceImpl<User, UUID, UserRepository> implements UserService {

    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    protected UserServiceImpl(UserRepository repo,
                              RoleService roleService,
                              BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(repo);
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    @Transactional
    public void cadastrarUsuario(CreateUserDto createUserDto) {
        var basicRole = roleService.findByName(Role.Values.BASIC.name());

        var userFromDb = repo.findByUsername(createUserDto.username());

        if (userFromDb.isPresent()) {
            throw new UsuarioJaCadastradoException(createUserDto.username());
        }

        var user = User.builder()
                .username(createUserDto.username())
                .password(bCryptPasswordEncoder.encode(createUserDto.password()))
                .roles(Set.of(basicRole))
                .build();
        repo.save(user);
    }
}
