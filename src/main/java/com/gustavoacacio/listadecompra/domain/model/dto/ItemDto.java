package com.gustavoacacio.listadecompra.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ItemDto implements Serializable {

    private Long id;
    private String nome;
    private Long quantidade;
    private BigDecimal valor;
    private Long compraId;
    private UUID localId;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private java.time.LocalDateTime createdDate;
    private String createdBy;
    
}
