package ru.rsatu.cursach.service.controller;

import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.data.dto.reference.BaseReferenceDto;
import ru.rsatu.cursach.data.dto.reference.BaseReferencePageDto;
import ru.rsatu.cursach.entity.base.BaseReferenceEntity;
import ru.rsatu.cursach.entity.reference.DeliveryStatus;
import ru.rsatu.cursach.mapper.ReferenceMapper;
import ru.rsatu.cursach.service.ReferenceService;

import java.util.List;
import java.util.stream.Collectors;

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

    public BaseReferencePageDto getDeliveryStatusList(Integer index, Integer size) {
        Page page = Page.of(index == null ? 0 : index, size);
        List<BaseReferenceEntity> deliveryStatusList = referenceService.getDeliveryStatusPage(page).stream()
                .map(entity -> (BaseReferenceEntity) entity)
                .collect(Collectors.toList());
        Long totalCnt = referenceService.getDeliveryStatusCount();
        return referenceMapper.mapToPageDto(deliveryStatusList, totalCnt);
    }
}
