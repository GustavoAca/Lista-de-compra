package com.gustavoacacio.listadecompra.domain.model;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("CarrinhoDeCompra")
public class CarrinhoDeCompra implements Serializable {

    @Builder.Default
    List<Long> itensIds = new ArrayList<>();
    @Id
    private String id;
}
