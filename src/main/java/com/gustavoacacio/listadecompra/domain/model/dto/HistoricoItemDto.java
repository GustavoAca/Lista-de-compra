package com.gustavoacacio.listadecompra.domain.model.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

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
    private OffsetDateTime modifiedDate;
    private String modifiedBy;
    private OffsetDateTime createdDate;
    private String createdBy;
}
