package ru.rsatu.trade.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.trade.entity.Delivery;

@ApplicationScoped
public class DeliveryRepository implements PanacheRepositoryBase<Delivery, Long> {

    public Delivery findByUUID(String uuid) {
        String query = "from Delivery where uuid = ?1";
        return find(query, uuid).firstResult();
    }
}
