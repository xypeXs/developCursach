package ru.rsatu.cursach.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.entity.SupplierOffer;
import ru.rsatu.cursach.entity.SupplierOfferPK;

@ApplicationScoped
public class SupplierOfferRepository implements PanacheRepositoryBase<SupplierOffer, SupplierOfferPK> {
}
