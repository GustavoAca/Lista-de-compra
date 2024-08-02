package com.gustavoacacio.listadecompra.domain.model.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ItemNoCarrinhoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Long quantidade;
    private BigDecimal valor;
    private Long carrinhoDeCompra;
    @Builder.Default
    private Boolean promocao = Boolean.FALSE;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private String createdBy;
}
