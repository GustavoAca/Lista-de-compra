package com.gustavoacacio.listadecompra.controller;

import com.gustavoacacio.listadecompra.controller.dto.CreateUserDto;
import com.gustavoacacio.listadecompra.domain.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody CreateUserDto createUserDto) {
        userService.cadastrarUsuario(createUserDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletar(@PathVariable UUID userId) {
        userService.deletar(userId);
        return ResponseEntity.noContent().build();
    }
}
