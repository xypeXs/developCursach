package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.data.reference.DeliveryStatusEnum;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.entity.reference.DeliveryStatus;
import ru.rsatu.cursach.repository.DeliveryRepository;
import ru.rsatu.cursach.service.kafka.producer.DeliveryResponseProducer;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class DeliveryService {

    @Inject
    ReferenceService referenceService;

    @Inject
    DeliveryResponseProducer deliveryResponseProducer;

    @Inject
    DeliveryRepository deliveryRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createDeliveryRequest(Delivery delivery) {
        deliveryRepository.persist(delivery);
        sendDeliveryResponse(delivery);
    }

    public void sendDeliveryResponse(Delivery delivery) {
        deliveryResponseProducer.sendDeliveryResponse(delivery);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveAll(List<Delivery> deliveryList) {
        deliveryRepository.persist(deliveryList);
    }

    public List<Delivery> getDeliveriesByStatus(DeliveryStatusEnum statusEnum) {
        return deliveryRepository.findAllByStatus(statusEnum);
    }

    public Delivery processDelivery(Delivery delivery) {
        DeliveryStatus newStatus = null;
        if (ThreadLocalRandom.current().nextBoolean())
            newStatus = referenceService.getDeliveryStatus(DeliveryStatusEnum.ACCEPTED_SUPPLIER);
        else
            newStatus = referenceService.getDeliveryStatus(DeliveryStatusEnum.REJECTED_SUPPLIER);
        delivery.setStatus(newStatus);
        return delivery;
    }
}
