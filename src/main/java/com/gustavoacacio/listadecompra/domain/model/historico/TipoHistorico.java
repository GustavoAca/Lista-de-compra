package com.gustavoacacio.listadecompra.domain.model.historico;

import com.gustavoacacio.listadecompra.core.providers.ApplicationContextProvider;
import com.gustavoacacio.listadecompra.domain.service.historico.tipohistorico.TipoHistoricoItemFactory;
import com.gustavoacacio.listadecompra.domain.service.historico.tipohistorico.TipoHistoricoService;

import java.io.Serializable;

public enum TipoHistorico {

    TIPO_HISTORICO_ITEM(TipoHistoricoItemFactory.class);

    private final Class<? extends TipoHistoricoService> fabricador;

    TipoHistorico(Class<? extends TipoHistoricoService> fabricador) {
        this.fabricador = fabricador;
    }

    public <T extends TipoTipoHistorico> T getFactory(Serializable entity) {
        return (T) ApplicationContextProvider.getBean(this.fabricador).fabricar(entity);
    }
}
