package com.gustavoacacio.listadecompra.domain.service;

import com.gustavoacacio.listadecompra.controller.dto.LoginRequest;
import com.gustavoacacio.listadecompra.controller.dto.LoginResponse;
import com.gustavoacacio.listadecompra.domain.model.Role;
import com.gustavoacacio.listadecompra.domain.model.User;
import com.gustavoacacio.listadecompra.domain.service.user.UserService;
import com.gustavoacacio.listadecompra.exception.CredencialException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.stream.Collectors;

@Component
public class TokenComponent {

    private final JwtEncoder jwtEncoder;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    public TokenComponent(JwtEncoder jwtEncoder,
                          UserService userService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.userService = userService;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        var user = userService.findByUsername(loginRequest.username());

        if (user.isEmpty() || !user.get().isLoginCorretc(loginRequest, passwordEncoder)) {
            throw new CredencialException();
        }

        var now = Instant.now();
        var expiresIn = 150L;
        var scope = user.get().getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.joining(" "));
        var claims = JwtClaimsSet.builder()
                .issuer("listadecompra")
                .subject(User.builder().id(user.get().getId()).username(user.get().getUsername()).build().toString())
                .expiresAt(now.plusSeconds(expiresIn))
                .issuedAt(now)
                .claim("scope", scope)
                .build();

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return new LoginResponse(jwtValue, expiresIn);
    }
}
