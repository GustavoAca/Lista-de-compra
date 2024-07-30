package com.gustavoacacio.listadecompra.domain.service.local;

import com.gustavoacacio.listadecompra.core.service.jpa.JpaService;
import com.gustavoacacio.listadecompra.domain.model.Local;
import com.gustavoacacio.listadecompra.domain.model.dto.LocalDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface LocalService extends JpaService<Local, UUID> {

    LocalDto cadastrar(LocalDto localDto);

    Page<LocalDto> listarPaginado(Pageable pageable);
}
