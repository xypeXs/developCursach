package ru.rsatu.trade.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.trade.entity.StorageGood;
import ru.rsatu.trade.entity.StorageGoodPK;

@ApplicationScoped
public class StorageGoodRepository implements PanacheRepositoryBase<StorageGood, StorageGoodPK> {
}
