package com.gustavoacacio.listadecompra.domain.mapper;

import com.gustavoacacio.listadecompra.domain.model.dto.HistoricoItemDto;
import com.gustavoacacio.listadecompra.domain.model.historico.HistoricoItem;
import org.springframework.stereotype.Component;

@Component
public class HistoricoItemMapper {

    public HistoricoItem toEntity(HistoricoItemDto dto) {
        return HistoricoItem.builder()
                .id(dto.getId())
                .itemId(dto.getItemId())
                .compraId(dto.getCompraId())
                .createdBy(dto.getCreatedBy())
                .createdDate(dto.getCreatedDate())
                .modifiedBy(dto.getModifiedBy())
                .modifiedDate(dto.getModifiedDate())
                .build();
    }

    public HistoricoItemDto toDto(HistoricoItem entity) {
        return HistoricoItemDto.builder()
                .id(entity.getId())
                .itemId(entity.getItemId())
                .compraId(entity.getCompraId())
                .createdBy(entity.getCreatedBy())
                .createdDate(entity.getCreatedDate())
                .modifiedBy(entity.getModifiedBy())
                .modifiedDate(entity.getModifiedDate())
                .build();
    }
}
