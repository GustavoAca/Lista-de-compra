package com.gustavoacacio.listadecompra.domain.model.historico;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "historico_item")
public class HistoricoItem extends EntityAbstract implements TipoTipoHistorico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "compra_id")
    private Long compraId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "valor")
    private BigDecimal valorItem;
}
