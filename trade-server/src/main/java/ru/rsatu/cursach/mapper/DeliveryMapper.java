package ru.rsatu.cursach.mapper;

import jakarta.inject.Inject;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.cursach.config.MapstructConfig;
import ru.rsatu.cursach.data.dto.delivery.DeliveryCreateRequestDto;
import ru.rsatu.cursach.data.dto.delivery.DeliveryResponseDto;
import ru.rsatu.cursach.data.enums.reference.DeliveryStatusEnum;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.service.GoodService;
import ru.rsatu.cursach.service.ReferenceService;
import ru.rsatu.cursach.service.StorageService;
import ru.rsatu.cursach.service.SupplierService;

import java.math.BigDecimal;

@Mapper(
        config = MapstructConfig.class,
        imports = {BigDecimal.class, DeliveryStatusEnum.class},
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
    @Mapping(target = "rating", expression = "java(BigDecimal.ZERO)")
    @Mapping(target = "status", expression = "java(referenceService.getDeliveryStatus(DeliveryStatusEnum.PENDING))")
    public abstract Delivery mapToDelivery(DeliveryCreateRequestDto createRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "goodInfo", source = "good", qualifiedByName = "mapToGoodDto")
    @Mapping(target = "storageInfo", source = "storage", qualifiedByName = "mapToStorageDto")
    @Mapping(target = "supplierInfo", source = "supplier", qualifiedByName = "mapToSupplierDto")
    @Mapping(target = "deliveryDate", source = "deliveryDate")
    @Mapping(target = "deliveryStatus", source = "status", qualifiedByName = "referenceBase")
    public abstract DeliveryResponseDto mapToResponse(Delivery delivery);
}
