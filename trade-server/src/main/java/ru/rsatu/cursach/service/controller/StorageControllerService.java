package ru.rsatu.cursach.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.data.dto.storage.StorageCreateRequestDto;
import ru.rsatu.cursach.data.dto.storage.StorageResponseDto;
import ru.rsatu.cursach.data.dto.storage.StorageUpdateRequestDto;
import ru.rsatu.cursach.entity.Storage;
import ru.rsatu.cursach.mapper.StorageMapper;
import ru.rsatu.cursach.service.StorageService;

@ApplicationScoped
public class StorageControllerService {

    @Inject
    StorageService storageService;

    @Inject
    StorageMapper storageMapper;

    public StorageResponseDto getStorageInfo(Long id) {
        Storage storage = storageService.getStorage(id);
        return storageMapper.mapToResponse(storage);
    }

    public StorageResponseDto createStorage(StorageCreateRequestDto createRequestDto) {
        Storage storage = storageMapper.mapToStorage(createRequestDto);
        storageService.createStorage(storage);
        return storageMapper.mapToResponse(storage);
    }

    public StorageResponseDto updateStorage(Long id, StorageUpdateRequestDto updateRequestDto) {
        Storage srcStorage = storageMapper.mapToStorage(updateRequestDto);
        storageService.updateStorage(id, srcStorage);
        Storage storage = storageService.getStorage(id);
        return storageMapper.mapToResponse(storage);
    }

    public void deleteStorage(Long id) {
        Storage storage = storageService.getStorage(id);
        storageService.deleteStorage(storage);
    }
}
