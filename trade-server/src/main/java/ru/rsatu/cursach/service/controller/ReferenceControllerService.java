package ru.rsatu.cursach.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.data.dto.reference.BaseReferenceDto;
import ru.rsatu.cursach.entity.reference.DeliveryStatus;
import ru.rsatu.cursach.mapper.ReferenceMapper;
import ru.rsatu.cursach.service.ReferenceService;

@ApplicationScoped
public class ReferenceControllerService {

    @Inject
    ReferenceService referenceService;

    @Inject
    ReferenceMapper referenceMapper;

    public BaseReferenceDto getDeliveryStatus(String code) {
        DeliveryStatus deliveryStatus = referenceService.getDeliveryStatus(code);
        return referenceMapper.mapToDto(deliveryStatus);
    }
}
