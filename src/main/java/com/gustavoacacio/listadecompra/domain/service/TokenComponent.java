package com.gustavoacacio.listadecompra.domain.service;

import com.gustavoacacio.listadecompra.controller.dto.LoginRequest;
import com.gustavoacacio.listadecompra.controller.dto.LoginResponse;
import com.gustavoacacio.listadecompra.domain.model.Role;
import com.gustavoacacio.listadecompra.domain.model.User;
import com.gustavoacacio.listadecompra.domain.model.dto.UserSubjectDto;
import com.gustavoacacio.listadecompra.domain.service.user.UserService;
import com.gustavoacacio.listadecompra.exception.CredencialException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TokenComponent {

    private final JwtEncoder jwtEncoder;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final static Long EXPIRE_IS = 3050L;

    public TokenComponent(JwtEncoder jwtEncoder,
                          UserService userService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = jwtEncoder;
        this.userService = userService;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    public LoginResponse login(LoginRequest loginRequest) {
        var user = userService.findByUsername(loginRequest.username());

        validar(user, loginRequest);

        var claims = criarClaims(user.get());

        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        return new LoginResponse(jwtValue, EXPIRE_IS);
    }

    private JwtClaimsSet criarClaims(User user) {
        var now = Instant.now();

        var scope = user.getRoles().stream()
                .map(Role::getName)
                .collect(Collectors.joining(" "));
        return JwtClaimsSet.builder()
                .issuer("listadecompra")
                .subject(UserSubjectDto.builder().userId(user.getId()).username(user.getUsername()).build().toString())
                .expiresAt(now.plusSeconds(EXPIRE_IS))
                .issuedAt(now)
                .claim("scope", scope)
                .build();
    }

    private void validar(Optional<User> user, LoginRequest loginRequest) {
        if (user.isEmpty() || !user.get().isLoginCorretc(loginRequest, passwordEncoder)) {
            throw new CredencialException();
        }
    }
}
