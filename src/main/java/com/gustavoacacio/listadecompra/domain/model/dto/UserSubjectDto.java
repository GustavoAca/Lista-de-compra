package com.gustavoacacio.listadecompra.domain.model.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserSubjectDto(UUID userId,
                             String username) {
}
