package ru.rsatu.cursach.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.entity.SupplierOffer;

@ApplicationScoped
public class SupplierOfferRepository implements PanacheRepositoryBase<SupplierOffer, Long> {

    public Long getSameOfferActiveCount(SupplierOffer supplierOffer) {
        String query = "supplier = ?1 AND good = ?2 AND isActive = true";
        return count(query, supplierOffer.getSupplier(), supplierOffer.getGood());
    }
}
