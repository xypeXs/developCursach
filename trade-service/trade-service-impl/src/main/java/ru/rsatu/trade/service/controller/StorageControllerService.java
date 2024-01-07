package ru.rsatu.trade.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.trade.data.dto.storage.StorageCreateRequestDto;
import ru.rsatu.trade.data.dto.storage.StorageGoodResponseDto;
import ru.rsatu.trade.data.dto.storage.StorageResponseDto;
import ru.rsatu.trade.data.dto.storage.StorageUpdateRequestDto;
import ru.rsatu.trade.entity.Storage;
import ru.rsatu.trade.mapper.StorageMapper;
import ru.rsatu.trade.service.StorageService;

import java.util.List;

@ApplicationScoped
public class StorageControllerService {

    @Inject
    StorageService storageService;

    @Inject
    StorageMapper storageMapper;

    @Transactional
    public StorageResponseDto getStorageInfo(Long id) {
        Storage storage = storageService.getStorage(id);
        return storageMapper.mapToResponse(storage);
    }

    @Transactional
    public List<StorageGoodResponseDto> getStorageGoodList(Long id) {
        Storage storage = storageService.getStorage(id);
        return storageMapper.mapToStorageGoodResponse(storage.getStorageGoodList());
    }

    @Transactional
    public StorageResponseDto createStorage(StorageCreateRequestDto createRequestDto) {
        Storage storage = storageMapper.mapToStorage(createRequestDto);
        storageService.createStorage(storage);
        return storageMapper.mapToResponse(storage);
    }

    @Transactional
    public StorageResponseDto updateStorage(Long id, StorageUpdateRequestDto updateRequestDto) {
        Storage srcStorage = storageMapper.mapToStorage(updateRequestDto);
        storageService.updateStorage(id, srcStorage);
        Storage storage = storageService.getStorage(id);
        return storageMapper.mapToResponse(storage);
    }

    @Transactional
    public void deleteStorage(Long id) {
        storageService.deleteStorage(id);
    }
}
