package com.gustavoacacio.listadecompra.domain.model.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarrinhoDeCompraDto implements Serializable {

    private Long id;
    @Builder.Default
    private List<ItemNoCarrinhoDto> itens = new ArrayList<>();
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private String createdBy;
}
