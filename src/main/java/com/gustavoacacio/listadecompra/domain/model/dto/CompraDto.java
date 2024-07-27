package com.gustavoacacio.listadecompra.domain.model.dto;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CompraDto extends EntityAbstract {

    private Long id;

    @Builder.Default
    private List<ItemDto> items = new LinkedList<>();

    private BigDecimal valorTotal;
}
