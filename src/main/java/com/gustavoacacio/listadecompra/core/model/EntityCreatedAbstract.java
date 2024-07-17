package com.gustavoacacio.listadecompra.core.model;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import java.time.OffsetDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class EntityCreatedAbstract {

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private OffsetDateTime createdDate;

    @Column(name = "created_by", nullable = false, updatable = false)
    @CreatedBy
    private String createdBy;

}
