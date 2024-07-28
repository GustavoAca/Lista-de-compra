package com.gustavoacacio.listadecompra.domain.service.historico.tipohistorico;

import com.gustavoacacio.listadecompra.domain.model.historico.TipoTipoHistorico;

import java.io.Serializable;

public interface TipoHistoricoService<T extends Serializable, E extends TipoTipoHistorico> {
    E fabricar(T entity);
}
