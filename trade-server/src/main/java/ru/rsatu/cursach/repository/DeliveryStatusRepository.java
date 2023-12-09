package ru.rsatu.cursach.repository;

import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.entity.reference.DeliveryStatus;
import ru.rsatu.cursach.repository.BaseReferenceRepository;

@ApplicationScoped
public class DeliveryStatusRepository extends BaseReferenceRepository<DeliveryStatus> {
}
