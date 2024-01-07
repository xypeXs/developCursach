package ru.rsatu.trade.config;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(targets = {
        ru.rsatu.trade.data.dto.storage.StorageResponseDto.class,
        ru.rsatu.trade.data.dto.storage.BaseStorageRequestDto.class,
        ru.rsatu.trade.data.dto.storage.StorageGoodResponseDto.class,
        ru.rsatu.trade.data.dto.storage.StorageUpdateRequestDto.class,
        ru.rsatu.trade.data.dto.storage.StorageCreateRequestDto.class,
        ru.rsatu.trade.data.dto.delivery.DeliveryResponseDto.class,
        ru.rsatu.trade.data.dto.delivery.DeliveryCreateRequestDto.class,
        ru.rsatu.trade.data.dto.offer.SupplierOfferCreateRequestDto.class,
        ru.rsatu.trade.data.dto.offer.SupplierOfferResponseDto.class,
        ru.rsatu.trade.data.dto.good.BaseGoodRequestDto.class,
        ru.rsatu.trade.data.dto.good.GoodResponseDto.class,
        ru.rsatu.trade.data.dto.good.GoodUpdateRequestDto.class,
        ru.rsatu.trade.data.dto.good.GoodCreateRequestDto.class,
        ru.rsatu.trade.data.dto.exception.BaseBusinessResponseDto.class,
        ru.rsatu.trade.data.dto.supplier.SupplierResponseDto.class,
        ru.rsatu.trade.data.dto.supplier.SupplierUpdateRequestDto.class,
        ru.rsatu.trade.data.dto.supplier.SupplierCreateRequestDto.class,
        ru.rsatu.trade.data.dto.supplier.BaseSupplierRequestDto.class,
        ru.rsatu.trade.data.dto.supplier.BaseSupplierResponseDto.class,
        ru.rsatu.trade.data.dto.reference.BaseReferenceDto.class,
        ru.rsatu.trade.data.dto.reference.BaseReferencePageDto.class,
        ru.rsatu.trade.data.dto.reference.BasePageDto.class,
        ru.rsatu.model.kafka.DeliveryResponseRecord.class,
        ru.rsatu.model.kafka.DeliveryRequestRecord.class,
        ru.rsatu.model.kafka.KafkaConstant.class
})
public class NativeConfiguration {
}
