package com.gustavoacacio.listadecompra.domain.service.compra;

import com.gustavoacacio.listadecompra.core.service.jpa.JpaService;
import com.gustavoacacio.listadecompra.domain.model.Compra;
import com.gustavoacacio.listadecompra.domain.model.dto.CompraDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CompraService extends JpaService<Compra, Long> {

    CompraDto salvar(CompraDto compraDto);

    Page<CompraDto> listar(Pageable pageable);
}
