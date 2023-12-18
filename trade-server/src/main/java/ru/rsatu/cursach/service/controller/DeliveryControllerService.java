package ru.rsatu.cursach.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.data.dto.delivery.DeliveryCreateRequestDto;
import ru.rsatu.cursach.data.dto.delivery.DeliveryResponseDto;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.mapper.DeliveryMapper;
import ru.rsatu.cursach.service.DeliveryService;

@ApplicationScoped
public class DeliveryControllerService {

    @Inject
    DeliveryService deliveryService;

    @Inject
    DeliveryMapper deliveryMapper;

    @Transactional
    public DeliveryResponseDto createDeliveryRequest(DeliveryCreateRequestDto createRequestDto) {
        Delivery delivery = deliveryMapper.mapToDelivery(createRequestDto);
        deliveryService.saveDeliveryRequest(delivery);
        deliveryService.sendDeliveryRequest(delivery);
        return deliveryMapper.mapToResponse(delivery);
    }

    @Transactional
    public DeliveryResponseDto getDelivery(String uuid) {
        Delivery delivery = deliveryService.getDeliveryByUUID(uuid);
        return deliveryMapper.mapToResponse(delivery);
    }
}
