package ru.rsatu.cursach.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.data.reference.DeliveryStatusEnum;
import ru.rsatu.cursach.entity.Delivery;

import java.util.List;

@ApplicationScoped
public class DeliveryRepository implements PanacheRepositoryBase<Delivery, Long> {

    public List<Delivery> findAllByStatus(DeliveryStatusEnum statusEnum) {
        String query = "from Delivery where status.code = ?1";
        return find(query, statusEnum.getCode()).list();
    }

    public Delivery findByUUID(String uuid) {
        String query = "from Delivery where uuid = ?1";
        return find(query, uuid).firstResult();
    }
}
