package ru.rsatu.supplier.service;

import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.supplier.data.reference.DeliveryStatusEnum;
import ru.rsatu.supplier.entity.base.BaseReferenceEntity;
import ru.rsatu.supplier.entity.reference.DeliveryStatus;
import ru.rsatu.supplier.repository.BaseReferenceRepository;
import ru.rsatu.supplier.repository.DeliveryStatusRepository;

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
