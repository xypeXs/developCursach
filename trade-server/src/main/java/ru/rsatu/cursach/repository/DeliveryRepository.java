package ru.rsatu.cursach.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.entity.Delivery;

@ApplicationScoped
public class DeliveryRepository implements PanacheRepositoryBase<Delivery, Long> {
}
