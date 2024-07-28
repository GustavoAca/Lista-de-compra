package com.gustavoacacio.listadecompra.domain.model.dto;

import com.gustavoacacio.listadecompra.domain.model.Item;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
    @Builder.Default
    private List<Item> itens = new ArrayList<>();
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private java.time.LocalDateTime createdDate;
    private String createdBy;
}
