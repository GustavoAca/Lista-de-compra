package com.gustavoacacio.listadecompra.core.config.security;

import com.gustavoacacio.listadecompra.domain.model.Role;
import com.gustavoacacio.listadecompra.domain.model.User;
import com.gustavoacacio.listadecompra.domain.service.role.RoleService;
import com.gustavoacacio.listadecompra.domain.service.user.UserService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class AdminConfig implements CommandLineRunner {

    private final RoleService roleService;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminConfig(RoleService roleService,
                       UserService userService,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var roleAdmin = roleService.findByName(Role.Values.ADMIN.name());

        var userAdmin = userService.findByUsername("gustavo.acacio@gmail.com");

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("Admin á existe");
                },
                () -> {
                    var user = User.builder()
                            .username("gustavo.acacio@gmail.com")
                            .password(bCryptPasswordEncoder.encode("1234"))
                            .roles(Set.of(roleAdmin))
                            .build();
                    userService.salvar(user);
                }
        );
    }
}
