package com.gustavoacacio.listadecompra.domain.model.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class LocalDto {

    private UUID id;
    private String nome;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private String createdBy;
}
