package com.gustavoacacio.listadecompra.domain.model;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "compra")
public class Compra extends EntityAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra", orphanRemoval = true)
    @Builder.Default
    private List<Item> items = new LinkedList<>();

    @Column(name = "valor_total")
    private BigDecimal valorTotal;
}
