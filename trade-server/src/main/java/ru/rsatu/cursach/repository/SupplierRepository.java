package ru.rsatu.cursach.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.entity.Supplier;

@ApplicationScoped

public class SupplierRepository implements PanacheRepositoryBase<Supplier, Long> {
}