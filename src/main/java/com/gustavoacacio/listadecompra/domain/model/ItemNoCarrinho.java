package com.gustavoacacio.listadecompra.domain.model;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.domain.model.carrinhodecompra.CarrinhoDeCompra;
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
@Table(name = "itens_no_carrinho")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class ItemNoCarrinho extends EntityAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    private Long quantidade;

    private BigDecimal valor;

    @Builder.Default
    private Boolean promocao = Boolean.FALSE;

    @OneToOne
    @JoinColumn(name = "carrinho_de_compra_id")
    private CarrinhoDeCompra carrinhoDeCompra;
}
