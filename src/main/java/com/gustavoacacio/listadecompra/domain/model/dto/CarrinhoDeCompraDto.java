package com.gustavoacacio.listadecompra.domain.model.dto;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarrinhoDeCompraDto implements Serializable {

    private Long id;
    @Builder.Default
    private List<ItemNoCarrinhoDto> itens = new ArrayList<>();
    private UUID userId;
    private LocalDateTime modifiedDate;
    private String modifiedBy;
    private LocalDateTime createdDate;
    private String createdBy;
}
