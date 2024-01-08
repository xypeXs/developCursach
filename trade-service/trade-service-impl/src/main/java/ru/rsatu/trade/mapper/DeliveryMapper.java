package ru.rsatu.trade.mapper;

import jakarta.inject.Inject;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.rsatu.trade.config.MapstructConfig;
import ru.rsatu.trade.data.dto.delivery.DeliveryCreateRequestDto;
import ru.rsatu.trade.data.dto.delivery.DeliveryResponseDto;
import ru.rsatu.trade.data.enums.reference.DeliveryStatusEnum;
import ru.rsatu.trade.entity.Delivery;
import ru.rsatu.model.kafka.DeliveryRequestRecord;
import ru.rsatu.model.kafka.DeliveryResponseRecord;
import ru.rsatu.trade.service.OfferService;
import ru.rsatu.trade.service.ReferenceService;
import ru.rsatu.trade.service.StorageService;

import java.math.BigDecimal;
import java.util.UUID;

@Mapper(
        config = MapstructConfig.class,
        imports = {BigDecimal.class, DeliveryStatusEnum.class, UUID.class},
        uses = {StorageMapper.class, GoodMapper.class, SupplierMapper.class, ReferenceMapper.class}
)
public abstract class DeliveryMapper {

    @Inject
    StorageService storageService;

    @Inject
    ReferenceService referenceService;

    @Inject
    OfferService offerService;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "supplierOffer", expression = "java(offerService.getSupplierOffer(createRequestDto.getSupplierOfferId()))")
    @Mapping(target = "storage", expression = "java(storageService.getStorage(createRequestDto.getStorageId()))")
    @Mapping(target = "status", expression = "java(referenceService.getDeliveryStatus(DeliveryStatusEnum.PENDING))")
    @Mapping(target = "uuid", expression = "java(UUID.randomUUID().toString())")
    @Mapping(target = "quantity", source = "quantity")
    public abstract Delivery mapToDelivery(DeliveryCreateRequestDto createRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "goodInfo", source = "supplierOffer.good", qualifiedByName = "mapToGoodDto")
    @Mapping(target = "storageInfo", source = "storage", qualifiedByName = "mapToStorageDto")
    @Mapping(target = "supplierInfo", source = "supplierOffer.supplier", qualifiedByName = "mapToSupplierDto")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "deliveryStatus", source = "status", qualifiedByName = "referenceBase")
    @Mapping(target = "quantity", source = "quantity")
    @Mapping(target = "price", source = "supplierOffer.price")
    public abstract DeliveryResponseDto mapToResponse(Delivery delivery);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "deliveryUUID", source = "uuid")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "storageId", source = "storage.storageId")
    @Mapping(target = "supplierOfferId", source = "supplierOffer.id")
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
