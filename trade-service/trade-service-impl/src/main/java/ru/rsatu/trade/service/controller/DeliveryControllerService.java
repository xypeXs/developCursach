package ru.rsatu.trade.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.trade.data.dto.delivery.DeliveryCreateRequestDto;
import ru.rsatu.trade.data.dto.delivery.DeliveryResponseDto;
import ru.rsatu.trade.entity.Delivery;
import ru.rsatu.trade.mapper.DeliveryMapper;
import ru.rsatu.trade.service.DeliveryService;

@ApplicationScoped
public class DeliveryControllerService {

    @Inject
    DeliveryService deliveryService;

    @Inject
    DeliveryMapper deliveryMapper;

    @Transactional
    public DeliveryResponseDto createDeliveryRequest(DeliveryCreateRequestDto createRequestDto) {
        Delivery delivery = deliveryMapper.mapToDelivery(createRequestDto);
        deliveryService.saveDelivery(delivery);
        deliveryService.sendDeliveryRequest(delivery);
        return deliveryMapper.mapToResponse(delivery);
    }

    @Transactional
    public DeliveryResponseDto getDelivery(String uuid) {
        Delivery delivery = deliveryService.getDeliveryByUUID(uuid);
        return deliveryMapper.mapToResponse(delivery);
    }
}
