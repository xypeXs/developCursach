package ru.rsatu.trade.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.trade.entity.Supplier;

@ApplicationScoped

public class SupplierRepository implements PanacheRepositoryBase<Supplier, Long> {
}
