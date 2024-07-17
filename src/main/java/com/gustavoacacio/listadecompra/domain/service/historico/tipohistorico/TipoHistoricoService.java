package com.gustavoacacio.listadecompra.domain.service.historico.tipohistorico;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.domain.model.historico.TipoTipoHistorico;

public interface TipoHistoricoService<T extends EntityAbstract, E extends TipoTipoHistorico> {
    E fabricar(T entity);
}
