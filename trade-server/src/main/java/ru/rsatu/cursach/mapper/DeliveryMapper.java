package ru.rsatu.cursach.mapper;

import jakarta.inject.Inject;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.rsatu.cursach.config.MapstructConfig;
import ru.rsatu.cursach.data.dto.delivery.DeliveryCreateRequestDto;
import ru.rsatu.cursach.data.dto.delivery.DeliveryResponseDto;
import ru.rsatu.cursach.data.enums.reference.DeliveryStatusEnum;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.model.kafka.DeliveryRequestRecord;
import ru.rsatu.cursach.model.kafka.DeliveryResponseRecord;
import ru.rsatu.cursach.service.GoodService;
import ru.rsatu.cursach.service.ReferenceService;
import ru.rsatu.cursach.service.StorageService;
import ru.rsatu.cursach.service.SupplierService;

import java.math.BigDecimal;
import java.util.UUID;

@Mapper(
        config = MapstructConfig.class,
        imports = {BigDecimal.class, DeliveryStatusEnum.class, UUID.class},
        uses = {StorageMapper.class, GoodMapper.class, SupplierMapper.class, ReferenceMapper.class}
)
public abstract class DeliveryMapper {

    @Inject
    SupplierService supplierService;

    @Inject
    StorageService storageService;

    @Inject
    GoodService goodService;

    @Inject
    ReferenceService referenceService;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "good", expression = "java(goodService.getGood(createRequestDto.getGoodId()))")
    @Mapping(target = "storage", expression = "java(storageService.getStorage(createRequestDto.getStorageId()))")
    @Mapping(target = "supplier", expression = "java(supplierService.getSupplier(createRequestDto.getSupplierId()))")
    @Mapping(target = "rating", expression = "java(0)")
    @Mapping(target = "status", expression = "java(referenceService.getDeliveryStatus(DeliveryStatusEnum.PENDING))")
    @Mapping(target = "uuid", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "quantity", source = "quantity")
    public abstract Delivery mapToDelivery(DeliveryCreateRequestDto createRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "goodInfo", source = "good", qualifiedByName = "mapToGoodDto")
    @Mapping(target = "storageInfo", source = "storage", qualifiedByName = "mapToStorageDto")
    @Mapping(target = "supplierInfo", source = "supplier", qualifiedByName = "mapToSupplierDto")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "deliveryStatus", source = "status", qualifiedByName = "referenceBase")
    @Mapping(target = "quantity", source = "quantity")
    public abstract DeliveryResponseDto mapToResponse(Delivery delivery);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "deliveryUUID", source = "uuid")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "storageId", source = "storage.storageId")
    @Mapping(target = "goodId", source = "good.goodId")
    @Mapping(target = "supplierId", source = "supplier.id")
    @Mapping(target = "quantity", source = "quantity")
    public abstract DeliveryRequestRecord mapToDeliveryRecord(Delivery delivery);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "uuid", source = "deliveryUUID")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "status", expression = "java(referenceService.getDeliveryStatus(responseRecord.getStatusCode()))")
    public abstract Delivery mapToEntity(DeliveryResponseRecord responseRecord);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "status", source = "status")
    public abstract void updateDeliveryBySupplierResponse(Delivery src, @MappingTarget Delivery upd);
}
