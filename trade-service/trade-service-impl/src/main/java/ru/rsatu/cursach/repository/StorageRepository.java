package ru.rsatu.cursach.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.entity.Storage;

@ApplicationScoped
public class StorageRepository implements PanacheRepositoryBase<Storage, Long> {
}
