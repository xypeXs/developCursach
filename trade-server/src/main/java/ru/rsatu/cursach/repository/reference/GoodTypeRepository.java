package ru.rsatu.cursach.repository.reference;

import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.entity.reference.DeliveryStatus;
import ru.rsatu.cursach.repository.base.BaseReferenceRepository;

@ApplicationScoped
public class GoodTypeRepository extends BaseReferenceRepository<DeliveryStatus> {
}
