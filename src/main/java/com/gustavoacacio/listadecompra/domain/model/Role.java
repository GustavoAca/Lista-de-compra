package com.gustavoacacio.listadecompra.domain.model;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Role extends EntityAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public enum Values {
        ADMIN(1L),
        BASIC(2L);

        Long roleId;

        Values(Long roleId) {
            this.roleId = roleId;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
