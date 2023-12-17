package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.repository.DeliveryRepository;

@ApplicationScoped
public class DeliveryService {

    @Inject
    DeliveryRepository deliveryRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createDeliveryRequest(Delivery delivery) {
        // TODO validate storage volume and weight

        deliveryRepository.persist(delivery);
    }
}
