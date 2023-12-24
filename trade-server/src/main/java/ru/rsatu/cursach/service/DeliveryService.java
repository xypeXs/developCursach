package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.data.enums.reference.DeliveryStatusEnum;
import ru.rsatu.cursach.data.validation.service.Validation;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.exception.DeliveryException;
import ru.rsatu.cursach.mapper.DeliveryMapper;
import ru.rsatu.cursach.repository.DeliveryRepository;
import ru.rsatu.cursach.service.kafka.producer.DeliveryRequestProducer;

import java.util.Objects;

@ApplicationScoped
public class DeliveryService {

    @Inject
    StorageService storageService;

    @Inject
    DeliveryRepository deliveryRepository;

    @Inject
    DeliveryRequestProducer deliveryRequestProducer;

    @Inject
    DeliveryMapper deliveryMapper;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveDelivery(Delivery delivery) {
        // TODO validate storage volume and weight and Offer existence
        if (delivery.getSupplierOffer() == null || !delivery.getSupplierOffer().getIsActive())
            throw new DeliveryException(Validation.Message.DELIVERY_OFFER_PROHIBITED);
        deliveryRepository.persist(delivery);
    }

    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public void sendDeliveryRequest(Delivery delivery) {
        deliveryRequestProducer.sendDeliveryRequest(delivery);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void processDeliveryResponse(Delivery responseSrcDelivery) {
        Delivery updDelivery = deliveryRepository.findByUUID(responseSrcDelivery.getUuid());
        // TODO validate base info not changed
        if (Objects.equals(updDelivery.getStatus(), responseSrcDelivery.getStatus()))
            return;
        deliveryMapper.updateDeliveryBySupplierResponse(responseSrcDelivery, updDelivery);
        processDelivery(updDelivery);
        deliveryRepository.persist(updDelivery);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Delivery getDeliveryByUUID(String uuid) {
        return deliveryRepository.findByUUID(uuid);
    }

    private void processDelivery(Delivery delivery) {
        if (DeliveryStatusEnum.equals(DeliveryStatusEnum.DELIVERED, delivery.getStatus()))
            storageService.acceptDelivery(delivery);
    }
}
