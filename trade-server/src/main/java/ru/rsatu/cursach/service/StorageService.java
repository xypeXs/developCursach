package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.entity.Good;
import ru.rsatu.cursach.entity.Storage;
import ru.rsatu.cursach.entity.StorageGood;
import ru.rsatu.cursach.entity.StorageGoodPK;
import ru.rsatu.cursach.mapper.StorageMapper;
import ru.rsatu.cursach.repository.StorageGoodRepository;
import ru.rsatu.cursach.repository.StorageRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@ApplicationScoped
public class StorageService {

    @Inject
    GoodService goodService;

    @Inject
    StorageRepository storageRepository;

    @Inject
    StorageGoodRepository storageGoodRepository;

    @Inject
    StorageMapper storageMapper;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createStorage(Storage storage) {
        storageRepository.persist(storage);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Storage getStorage(Long id) {
        return storageRepository.findById(id);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void updateStorage(Long id, Storage srcStorage) {
        // TODO validate weight and volume values
        Storage updStorage = storageRepository.findById(id);
        storageMapper.updateStorage(srcStorage, updStorage);
        storageRepository.persist(updStorage);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void deleteStorage(Long id) {
        // TODO validate orphan goods
        Storage storage = storageRepository.findById(id);
        storage.setIsActive(false);
        storageRepository.persist(storage);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void acceptDelivery(Delivery delivery) {
        StorageGood storageGood = getStorageGoodOtCreateEmpty(delivery.getStorage(), delivery.getSupplierOffer().getGood());
        Long quantity = storageGood.getQuantity();
        storageGood.setQuantity(quantity + delivery.getQuantity());
        storageGoodRepository.persist(storageGood);
    }

    private StorageGood getStorageGoodOtCreateEmpty(Storage storage, Good good) {
        StorageGoodPK storageGoodPK = new StorageGoodPK(storage, good);
        return Optional.ofNullable(storageGoodRepository.findById(storageGoodPK))
                .orElse(StorageGood.empty(storageGoodPK));
    }

    public BigDecimal computeVolumeUsed(Storage storage) {
        if (storage == null)
            return BigDecimal.ZERO;
        return Optional.ofNullable(storage.getStorageGoodList()).orElse(new ArrayList<>()).stream()
                .map(storageGood -> {
                    Good good = storageGood.getStorageGoodId().getGood();
                    return goodService.computeVolume(good).multiply(BigDecimal.valueOf(storageGood.getQuantity()));
                })
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }

    public BigDecimal computeWeightUsed(Storage storage) {
        if (storage == null)
            return BigDecimal.ZERO;
        return Optional.ofNullable(storage.getStorageGoodList()).orElse(new ArrayList<>()).stream()
                .map(storageGood -> storageGood.getStorageGoodId().getGood().getWeight()
                        .multiply(BigDecimal.valueOf(storageGood.getQuantity())))
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
