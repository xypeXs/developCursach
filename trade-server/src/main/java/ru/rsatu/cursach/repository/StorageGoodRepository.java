package ru.rsatu.cursach.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.entity.StorageGood;
import ru.rsatu.cursach.entity.StorageGoodPK;

@ApplicationScoped
public class StorageGoodRepository implements PanacheRepositoryBase<StorageGood, StorageGoodPK> {
}
