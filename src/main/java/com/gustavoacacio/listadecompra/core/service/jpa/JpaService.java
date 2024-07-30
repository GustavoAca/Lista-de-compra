package com.gustavoacacio.listadecompra.core.service.jpa;

import com.gustavoacacio.listadecompra.core.model.EntityAbstract;
import com.gustavoacacio.listadecompra.core.service.BaseServiceAbstract;

import java.io.Serializable;

public interface JpaService<T extends EntityAbstract, K extends Serializable> extends BaseServiceAbstract<T, K> {
}
