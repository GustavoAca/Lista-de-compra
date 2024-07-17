package com.gustavoacacio.listadecompra.domain.model.dto;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.LastModifiedBy;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ItemDto extends EntityAbstract {
    private Long id;

    private String nome;

    private Long quantidade;

    private BigDecimal valor;

    private Long compraId;

    private OffsetDateTime modifiedDate;

    private String modifiedBy;

    private OffsetDateTime createdDate;

    private String createdBy;
}
