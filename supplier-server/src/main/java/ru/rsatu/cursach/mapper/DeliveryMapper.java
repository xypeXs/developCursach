package ru.rsatu.cursach.mapper;

import jakarta.inject.Inject;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.cursach.config.MapstructConfig;
import ru.rsatu.cursach.data.dto.DeliveryResponseDto;
import ru.rsatu.cursach.data.reference.DeliveryStatusEnum;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.model.kafka.DeliveryRequestRecord;
import ru.rsatu.cursach.model.kafka.DeliveryResponseRecord;
import ru.rsatu.cursach.service.ReferenceService;

@Mapper(
        config = MapstructConfig.class,
        imports = {DeliveryStatusEnum.class},
        uses = {ReferenceMapper.class}
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
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "deliveryStatus", source = "status", qualifiedByName = "referenceBase")
    @Mapping(target = "quantity", source = "quantity")
    public abstract DeliveryResponseDto mapToResponse(Delivery delivery);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "deliveryUUID", source = "uuid")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "statusCode", source = "status.code")
    @Mapping(target = "quantity", source = "quantity")
    public abstract DeliveryResponseRecord mapToRecord(Delivery delivery);
}
