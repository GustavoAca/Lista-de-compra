package com.gustavoacacio.listadecompra.domain.model.dto;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

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
}
