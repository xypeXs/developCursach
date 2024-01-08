package ru.rsatu.supplier.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import ru.rsatu.trade.data.dto.offer.SupplierOfferResponseDto;
import ru.rsatu.supplier.dto.delivery.DeliveryResponseDto;
import ru.rsatu.trade.data.dto.storage.StorageResponseDto;
import ru.rsatu.supplier.entity.Delivery;
import ru.rsatu.supplier.mapper.DeliveryMapper;
import ru.rsatu.supplier.service.DeliveryService;
import ru.rsatu.supplier.service.client.trade.StorageRestClient;
import ru.rsatu.supplier.service.client.trade.SupplierOfferRestClient;

@ApplicationScoped
public class DeliveryControllerService {

    @Inject
    DeliveryService deliveryService;

    @Inject
    DeliveryMapper deliveryMapper;

    @RestClient
    SupplierOfferRestClient supplierOfferRestClient;

    @RestClient
    StorageRestClient storageRestClient;

    @Transactional
    public DeliveryResponseDto getDelivery(String uuid) {
        Delivery delivery = deliveryService.getDeliveryByUUID(uuid);
        SupplierOfferResponseDto offerInfo = supplierOfferRestClient.getSupplierOfferInfo(delivery.getSupplierOfferId());
        StorageResponseDto storageInfo = storageRestClient.getStorageInfo(delivery.getStorageId());
        return deliveryMapper.mapToResponse(delivery, offerInfo, storageInfo);
    }
}
