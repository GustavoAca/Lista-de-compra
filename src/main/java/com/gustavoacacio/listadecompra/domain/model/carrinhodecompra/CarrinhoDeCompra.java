package com.gustavoacacio.listadecompra.domain.model.carrinhodecompra;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.domain.model.ItemNoCarrinho;
import com.gustavoacacio.listadecompra.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "carrinho_de_compra")
public class CarrinhoDeCompra extends EntityAbstract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User usuario;

    @OneToMany(mappedBy = "carrinhoDeCompra", cascade = CascadeType.ALL)
    private List<ItemNoCarrinho> itens = new ArrayList<>();
}
