package com.gustavoacacio.listadecompra.domain.model.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CompraDto implements Serializable {

    private Long id;
    @Builder.Default
    private List<ItemDto> items = new LinkedList<>();
    private BigDecimal valorTotal;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private String createdBy;
}
