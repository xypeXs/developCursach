package ru.rsatu.cursach.config;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection(targets = {
        ru.rsatu.cursach.data.dto.storage.StorageResponseDto.class,
        ru.rsatu.cursach.data.dto.storage.BaseStorageRequestDto.class,
        ru.rsatu.cursach.data.dto.storage.StorageGoodResponseDto.class,
        ru.rsatu.cursach.data.dto.storage.StorageUpdateRequestDto.class,
        ru.rsatu.cursach.data.dto.storage.StorageCreateRequestDto.class,
        ru.rsatu.cursach.data.dto.delivery.DeliveryResponseDto.class,
        ru.rsatu.cursach.data.dto.delivery.DeliveryCreateRequestDto.class,
        ru.rsatu.cursach.data.dto.offer.SupplierOfferCreateRequestDto.class,
        ru.rsatu.cursach.data.dto.offer.SupplierOfferResponseDto.class,
        ru.rsatu.cursach.data.dto.good.BaseGoodRequestDto.class,
        ru.rsatu.cursach.data.dto.good.GoodResponseDto.class,
        ru.rsatu.cursach.data.dto.good.GoodUpdateRequestDto.class,
        ru.rsatu.cursach.data.dto.good.GoodCreateRequestDto.class,
        ru.rsatu.cursach.data.dto.exception.BaseBusinessResponseDto.class,
        ru.rsatu.cursach.data.dto.supplier.SupplierResponseDto.class,
        ru.rsatu.cursach.data.dto.supplier.SupplierUpdateRequestDto.class,
        ru.rsatu.cursach.data.dto.supplier.SupplierCreateRequestDto.class,
        ru.rsatu.cursach.data.dto.supplier.BaseSupplierRequestDto.class,
        ru.rsatu.cursach.data.dto.supplier.BaseSupplierResponseDto.class,
        ru.rsatu.cursach.data.dto.reference.BaseReferenceDto.class,
        ru.rsatu.cursach.data.dto.reference.BaseReferencePageDto.class,
        ru.rsatu.cursach.data.dto.reference.BasePageDto.class,
        ru.rsatu.cursach.model.kafka.DeliveryResponseRecord.class,
        ru.rsatu.cursach.model.kafka.DeliveryRequestRecord.class,
        ru.rsatu.cursach.model.kafka.KafkaConstant.class
})
public class NativeConfiguration {
}
