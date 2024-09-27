package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.Local;
import com.gustavoacacio.listadecompra.domain.model.dto.LocalDto;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class LocalMapper {

    public Local toEntity(LocalDto localDto) {
        Local local = Local.builder()
                .id(localDto.getId())
                .nome(localDto.getNome())
                .createdBy(localDto.getCreatedBy())
                .createdDate(localDto.getCreatedDate())
                .modifiedBy(localDto.getModifiedBy())
                .modifiedDate(localDto.getModifiedDate())
                .build();
        if (Objects.nonNull(localDto.getVersion())) {
            local.setVersion(localDto.getVersion());
        }

        return local;
    }

    public LocalDto toDto(Local local) {
        LocalDto localDto = LocalDto.builder()
                .id(local.getId())
                .nome(local.getNome())
                .createdBy(local.getCreatedBy())
                .createdDate(local.getCreatedDate())
                .modifiedBy(local.getModifiedBy())
                .modifiedDate(local.getModifiedDate())
                .build();

        if (Objects.nonNull(local.getVersion())) {
            localDto.setVersion(local.getVersion());
        }

        return localDto;
    }
}
