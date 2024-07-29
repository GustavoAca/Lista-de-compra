package com.gustavoacacio.listadecompra.domain.model;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("CarrinhoDeCompra")
public class CarrinhoDeCompra extends EntityAbstract {

    @Id
    private String id;

    @Builder.Default
    List<Long> itensIds = new ArrayList<>();
}
