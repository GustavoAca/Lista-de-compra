package com.gustavoacacio.listadecompra.domain.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoItemDto {

    private Long id;
    private Long compraId;
    private Long itemId;
    private BigDecimal valorItem;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private String createdBy;
}
