package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.repository.DeliveryRepository;
import ru.rsatu.cursach.service.kafka.producer.DeliveryRequestProducer;

@ApplicationScoped
public class DeliveryService {

    @Inject
    DeliveryRepository deliveryRepository;

    @Inject
    DeliveryRequestProducer deliveryRequestProducer;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createDeliveryRequest(Delivery delivery) {
        // TODO validate storage volume and weight and Offer existence
        deliveryRequestProducer.sendDeliveryRequest(delivery);
        deliveryRepository.persist(delivery);
    }
}
