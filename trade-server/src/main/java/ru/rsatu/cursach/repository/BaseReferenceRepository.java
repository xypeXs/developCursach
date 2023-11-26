package ru.rsatu.cursach.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import ru.rsatu.cursach.entity.base.BaseReferenceEntity;

public class BaseReferenceRepository<E extends BaseReferenceEntity> implements PanacheRepositoryBase<E, Long> {
}
