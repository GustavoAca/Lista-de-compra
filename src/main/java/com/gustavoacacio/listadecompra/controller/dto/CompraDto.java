package com.gustavoacacio.listadecompra.controller.dto;

import com.gustavoacacio.listadecompra.domain.model.dto.ItemDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
public record CompraDto(Long id,
                        List<ItemDto> itemDtos,
                        OffsetDateTime modifiedDate,
                        String modifiedBy,
                        OffsetDateTime createdDate,
                        String createdBy,
                        Long version) {
}
