package ru.rsatu.supplier.repository;

import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.supplier.entity.reference.DeliveryStatus;

@ApplicationScoped
public class DeliveryStatusRepository extends BaseReferenceRepository<DeliveryStatus> {
}
