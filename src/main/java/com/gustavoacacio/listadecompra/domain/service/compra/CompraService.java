package com.gustavoacacio.listadecompra.domain.service.compra;

import com.gustavoacacio.listadecompra.controller.dto.CompraDto;
import com.gustavoacacio.listadecompra.core.service.BaseService;
import com.gustavoacacio.listadecompra.domain.model.Compra;

public interface CompraService extends BaseService<Compra, Long> {

    CompraDto salvar(CompraDto compraDto);
}
