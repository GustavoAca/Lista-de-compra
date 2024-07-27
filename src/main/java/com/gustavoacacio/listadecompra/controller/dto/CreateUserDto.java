package com.gustavoacacio.listadecompra.controller.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record CreateUserDto(@Valid @NotNull String username, @Valid @NotNull String password) {
}