package com.gustavoacacio.listadecompra.domain.model.dto;

import com.gustavoacacio.listadecompra.domain.model.historico.TipoTipoHistorico;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoricoItemDto implements Serializable, TipoTipoHistorico {

    private Long id;
    private Long compraId;
    private Long itemId;
    private UUID localId;
    private BigDecimal valorItem;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private String createdBy;
}
