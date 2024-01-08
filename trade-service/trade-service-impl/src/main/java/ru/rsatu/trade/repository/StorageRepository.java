package ru.rsatu.trade.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.trade.entity.Storage;

@ApplicationScoped
public class StorageRepository implements PanacheRepositoryBase<Storage, Long> {
}
