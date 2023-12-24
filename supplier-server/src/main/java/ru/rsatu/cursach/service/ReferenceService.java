package ru.rsatu.cursach.service;

import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.data.reference.DeliveryStatusEnum;
import ru.rsatu.cursach.entity.base.BaseReferenceEntity;
import ru.rsatu.cursach.entity.reference.DeliveryStatus;
import ru.rsatu.cursach.repository.BaseReferenceRepository;
import ru.rsatu.cursach.repository.DeliveryStatusRepository;

import java.util.List;

@ApplicationScoped
public class ReferenceService {

    @Inject
    DeliveryStatusRepository deliveryStatusRepository;

    @Transactional(Transactional.TxType.REQUIRED)
    public DeliveryStatus getDeliveryStatus(DeliveryStatusEnum statusEnum) {
        return getDeliveryStatus(statusEnum.getCode());
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public DeliveryStatus getDeliveryStatus(String code) {
        return getBaseReferenceEntityByCode(deliveryStatusRepository, code);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public List<DeliveryStatus> getDeliveryStatusPage(Page page) {
        return getBaseReferenceEntityPage(deliveryStatusRepository, page);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Long getDeliveryStatusCount() {
        return getBaseReferenceCount(deliveryStatusRepository);
    }

    private <E extends BaseReferenceEntity> E getBaseReferenceEntityByCode(BaseReferenceRepository<E> repository, String code) {
        return repository.findByCode(code);
    }

    private <E extends BaseReferenceEntity> List<E> getBaseReferenceEntityPage(BaseReferenceRepository<E> repository, Page page) {
        return repository.findAll().page(page).list();
    }

    private <E extends BaseReferenceEntity> Long getBaseReferenceCount(BaseReferenceRepository<E> repository) {
        return repository.count();
    }
}
