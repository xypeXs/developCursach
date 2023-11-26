package ru.rsatu.cursach.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.data.dto.reference.BaseReferenceDto;
import ru.rsatu.cursach.entity.GoodType;
import ru.rsatu.cursach.mapper.ReferenceMapper;
import ru.rsatu.cursach.service.ReferenceService;
import ru.rsatu.cursach.utils.EncryptionUtils;

@ApplicationScoped
public class ReferenceControllerService {

    @Inject
    ReferenceService referenceService;

    @Inject
    ReferenceMapper referenceMapper;

    public BaseReferenceDto getGoodType(String encryptedId) {
        Long id = EncryptionUtils.decryptToLong(encryptedId);
        GoodType goodType = referenceService.getGoodType(id);
        return referenceMapper.mapToDto(goodType);
    }
}
