package com.gustavoacacio.listadecompra.domain.model.historico;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;

public interface TipoHistoricoService<T extends EntityAbstract, E extends TipoTipoHistorico> {
    E fabricar(T entity);
}
