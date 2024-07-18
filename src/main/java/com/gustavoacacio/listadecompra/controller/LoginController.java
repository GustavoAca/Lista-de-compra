package com.gustavoacacio.listadecompra.controller;

import com.gustavoacacio.listadecompra.controller.dto.LoginRequest;
import com.gustavoacacio.listadecompra.controller.dto.LoginResponse;
import com.gustavoacacio.listadecompra.domain.service.TokenComponent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final TokenComponent tokenComponent;

    public LoginController(TokenComponent tokenComponent) {
        this.tokenComponent = tokenComponent;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(tokenComponent.login(loginRequest));
    }
}
