package ru.rsatu.cursach.repository.base;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import ru.rsatu.cursach.entity.base.BaseReferenceEntity;

public class BaseReferenceRepository<E extends BaseReferenceEntity> implements PanacheRepositoryBase<E, Long> {

    public E findByCode(String code) {
        return find("code = ?1", code).firstResult();
    }
}
