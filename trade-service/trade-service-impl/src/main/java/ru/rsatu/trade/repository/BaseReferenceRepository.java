package ru.rsatu.trade.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import ru.rsatu.trade.entity.base.BaseReferenceEntity;

public class BaseReferenceRepository<E extends BaseReferenceEntity> implements PanacheRepositoryBase<E, Long> {

    public E findByCode(String code) {
        return find("code = ?1", code).firstResult();
    }
}
