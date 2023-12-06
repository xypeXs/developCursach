package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.entity.base.BaseReferenceEntity;
import ru.rsatu.cursach.entity.reference.DeliveryStatus;
import ru.rsatu.cursach.repository.base.BaseReferenceRepository;
import ru.rsatu.cursach.repository.reference.GoodTypeRepository;

@ApplicationScoped
public class ReferenceService {

    @Inject
    GoodTypeRepository goodTypeRepository;

    public DeliveryStatus getDeliveryStatus(String code) {
        return getBaseReferenceEntityByCode(goodTypeRepository, code);
    }

    private <E extends BaseReferenceEntity> E getBaseReferenceEntityByCode(BaseReferenceRepository<E> repository, String code) {
        return repository.findByCode(code);
    }
}
