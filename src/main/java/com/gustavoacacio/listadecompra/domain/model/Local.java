package com.gustavoacacio.listadecompra.domain.model;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SuperBuilder
@Table(name = "locais")
public class Local extends EntityAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    @OneToMany(mappedBy = "local")
    @Builder.Default
    private List<Item> itens = new ArrayList<>();
}
