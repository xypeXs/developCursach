package ru.rsatu.supplier.mapper;

import jakarta.inject.Inject;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.supplier.config.MapstructConfig;
import ru.rsatu.trade.data.dto.offer.SupplierOfferResponseDto;
import ru.rsatu.supplier.dto.delivery.DeliveryResponseDto;
import ru.rsatu.supplier.data.reference.DeliveryStatusEnum;
import ru.rsatu.supplier.dto.storage.StorageResponseDto;
import ru.rsatu.supplier.entity.Delivery;
import ru.rsatu.model.kafka.DeliveryRequestRecord;
import ru.rsatu.model.kafka.DeliveryResponseRecord;
import ru.rsatu.supplier.service.ReferenceService;

@Mapper(
        config = MapstructConfig.class,
        imports = {DeliveryStatusEnum.class},
        uses = {ReferenceMapper.class, GoodMapper.class}
)
public abstract class DeliveryMapper {

    @Inject
    ReferenceService referenceService;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "supplierOfferId", source = "supplierOfferId")
    @Mapping(target = "storageId", source = "storageId")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "uuid", source = "deliveryUUID")
    @Mapping(target = "status", expression = "java(referenceService.getDeliveryStatus(DeliveryStatusEnum.PENDING_SUPPLIER))")
    @Mapping(target = "quantity", source = "quantity")
    public abstract Delivery mapToEntity(DeliveryRequestRecord requestRecord);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "uuid", source = "delivery.uuid")
    @Mapping(target = "deliveryDate", source = "delivery.deliveryDate")
    @Mapping(target = "deliveryStatus", source = "delivery.status", qualifiedByName = "referenceBase")
    @Mapping(target = "goodInfo", source = "offerInfo.goodInfo", qualifiedByName = "mapToGoodResponseDto")
    @Mapping(target = "quantity", source = "delivery.quantity")
    public abstract DeliveryResponseDto mapToResponse(Delivery delivery,
                                                      SupplierOfferResponseDto offerInfo,
                                                      StorageResponseDto storageInfo);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "deliveryUUID", source = "uuid")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "statusCode", source = "status.code")
    @Mapping(target = "quantity", source = "quantity")
    public abstract DeliveryResponseRecord mapToRecord(Delivery delivery);
}
