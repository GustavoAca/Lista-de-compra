package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.Local;
import com.gustavoacacio.listadecompra.domain.model.dto.LocalDto;
import org.springframework.stereotype.Component;

@Component
public class LocalMapper {

    public Local toDto(LocalDto localDto) {
        return Local.builder()
                .id(localDto.getId())
                .itens(localDto.getItens())
                .nome(localDto.getNome())
                .createdBy(localDto.getCreatedBy())
                .createdDate(localDto.getCreatedDate())
                .modifiedBy(localDto.getModifiedBy())
                .modifiedDate(localDto.getModifiedDate())
                .build();
    }

    public LocalDto toDto(Local local) {
        return LocalDto.builder()
                .id(local.getId())
                .itens(local.getItens())
                .nome(local.getNome())
                .createdBy(local.getCreatedBy())
                .createdDate(local.getCreatedDate())
                .modifiedBy(local.getModifiedBy())
                .modifiedDate(local.getModifiedDate())
                .build();
    }
}
