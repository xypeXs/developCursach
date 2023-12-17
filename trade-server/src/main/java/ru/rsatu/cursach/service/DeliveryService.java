package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.mapper.DeliveryMapper;
import ru.rsatu.cursach.repository.DeliveryRepository;
import ru.rsatu.cursach.service.kafka.producer.DeliveryRequestProducer;

@ApplicationScoped
public class DeliveryService {

    @Inject
    DeliveryRepository deliveryRepository;

    @Inject
    DeliveryRequestProducer deliveryRequestProducer;

    @Inject
    DeliveryMapper deliveryMapper;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createDeliveryRequest(Delivery delivery) {
        // TODO validate storage volume and weight and Offer existence
        deliveryRequestProducer.sendDeliveryRequest(delivery);
        deliveryRepository.persist(delivery);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void processDeliveryResponse(Delivery responseSrcDelivery) {
        Delivery updDelivery = deliveryRepository.findByUUID(responseSrcDelivery.getUuid());
        // TODO validate base info not changed
        deliveryMapper.updateDeliveryBySupplierResponse(responseSrcDelivery, updDelivery);
        deliveryRepository.persist(updDelivery);
    }
}
