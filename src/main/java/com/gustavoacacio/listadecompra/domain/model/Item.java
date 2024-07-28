package com.gustavoacacio.listadecompra.domain.model;

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
@Table(name = "itens")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Item extends EntityAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    private Long quantidade;

    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "local_id")
    private Local local;

    @Builder.Default
    private Boolean promocao = Boolean.FALSE;
}
