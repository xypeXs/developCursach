package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.commons.collections4.CollectionUtils;
import ru.rsatu.cursach.data.reference.DeliveryStatusEnum;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.entity.reference.DeliveryStatus;
import ru.rsatu.cursach.repository.DeliveryRepository;
import ru.rsatu.cursach.service.kafka.producer.DeliveryResponseProducer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@ApplicationScoped
public class DeliveryService {

    @Inject
    ReferenceService referenceService;

    @Inject
    DeliveryResponseProducer deliveryResponseProducer;

    @Inject
    DeliveryRepository deliveryRepository;

    @Transactional
    public void saveDeliveryRequest(Delivery delivery) {
        deliveryRepository.persist(delivery);
    }

    public void sendDeliveryResponse(Delivery delivery) {
        deliveryResponseProducer.sendDeliveryResponse(delivery);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public List<Delivery> getDeliveriesByStatus(DeliveryStatusEnum statusEnum) {
        return deliveryRepository.findAllByStatus(statusEnum);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Delivery getDeliveryByUUID(String uuid) {
        return deliveryRepository.findByUUID(uuid);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List<Delivery> processDeliveryRequests() {
        List<Delivery> pendingDeliveryList = getDeliveriesByStatus(DeliveryStatusEnum.PENDING_SUPPLIER);
        if (CollectionUtils.isEmpty(pendingDeliveryList))
            return new ArrayList<>();
        List<Delivery> processedDeliveries = pendingDeliveryList.stream()
                .map(this::processDeliveryRequest)
                .collect(Collectors.toList());
        deliveryRepository.persist(processedDeliveries);
        return processedDeliveries;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List<Delivery> processAcceptedDeliveries(DeliveryStatusEnum initialStatusEnum, DeliveryStatusEnum targetStatusEnum) {
        List<Delivery> aceptedDeliveryList = getDeliveriesByStatus(initialStatusEnum);
        if (CollectionUtils.isEmpty(aceptedDeliveryList))
            return new ArrayList<>();
        DeliveryStatus targetDeliveryStatus = referenceService.getDeliveryStatus(targetStatusEnum);
        List<Delivery> processedDeliveries = aceptedDeliveryList.stream()
                .map(delivery -> changeDeliveryStatus(delivery, targetDeliveryStatus))
                .collect(Collectors.toList());
        deliveryRepository.persist(processedDeliveries);
        return processedDeliveries;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public List<Delivery> processMovingDeliveries(DeliveryStatusEnum initialStatusEnum, DeliveryStatusEnum targetStatusEnum) {
        List<Delivery> almostDeliveredList = getDeliveriesByStatus(initialStatusEnum).stream()
                .filter(delivery -> !LocalDate.now().isBefore(delivery.getDeliveryDate()))
                .toList();
        if (CollectionUtils.isEmpty(almostDeliveredList))
            return new ArrayList<>();
        DeliveryStatus targetStatus = referenceService.getDeliveryStatus(targetStatusEnum);
        List<Delivery> processedDeliveries = almostDeliveredList.stream()
                .map(delivery -> changeDeliveryStatus(delivery, targetStatus))
                .collect(Collectors.toList());
        deliveryRepository.persist(processedDeliveries);
        return processedDeliveries;
    }

    public Delivery processDeliveryRequest(Delivery delivery) {
        DeliveryStatus newStatus = null;
        if (ThreadLocalRandom.current().nextBoolean())
            newStatus = referenceService.getDeliveryStatus(DeliveryStatusEnum.ACCEPTED_SUPPLIER);
        else
            newStatus = referenceService.getDeliveryStatus(DeliveryStatusEnum.REJECTED_SUPPLIER);
        delivery.setStatus(newStatus);
        return delivery;
    }

    public Delivery changeDeliveryStatus(Delivery delivery, DeliveryStatus deliveryStatus) {
        delivery.setStatus(deliveryStatus);
        return delivery;
    }
}
