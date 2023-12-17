package ru.rsatu.cursach.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.data.dto.delivery.DeliveryCreateRequestDto;
import ru.rsatu.cursach.data.dto.delivery.DeliveryResponseDto;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.mapper.DeliveryMapper;

@ApplicationScoped
public class DeliveryControllerService {

    @Inject
    DeliveryMapper deliveryMapper;

    public DeliveryResponseDto createDeliveryRequest(DeliveryCreateRequestDto createRequestDto) {
        Delivery delivery = deliveryMapper.mapToDelivery(createRequestDto);

    }
}
