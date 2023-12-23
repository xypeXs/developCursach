package ru.rsatu.cursach.mapper;

import jakarta.inject.Inject;
import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.rsatu.cursach.config.MapstructConfig;
import ru.rsatu.cursach.data.dto.offer.SupplierOfferCreateRequestDto;
import ru.rsatu.cursach.data.dto.offer.SupplierOfferResponseDto;
import ru.rsatu.cursach.entity.SupplierOffer;
import ru.rsatu.cursach.service.GoodService;
import ru.rsatu.cursach.service.SupplierService;

import java.math.BigDecimal;
import java.util.List;

@Mapper(
        config = MapstructConfig.class,
        uses = {GoodMapper.class, SupplierMapper.class},
        imports = {BigDecimal.class}
)
public abstract class OfferMapper {

    @Inject
    GoodService goodService;

    @Inject
    SupplierService supplierService;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "supplier", expression = "java(supplierService.getSupplier(supplierId))")
    @Mapping(target = "good", expression = "java(goodService.getGood(goodId))")
    @Mapping(target = "price", source = "createRequestDto.price")
    @Mapping(target = "isActive", expression = "java(true)")
    public abstract SupplierOffer mapToSupplierOffer(Long supplierId, Long goodId,
                                                     SupplierOfferCreateRequestDto createRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "offerId", source = "id")
    @Mapping(target = "supplierInfo", source = "supplier", qualifiedByName = "mapToSupplierDto")
    @Mapping(target = "goodInfo", source = "good", qualifiedByName = "mapToGoodDto")
    @Mapping(target = "price", source = "price")
    public abstract SupplierOfferResponseDto mapToOfferFullResponse(SupplierOffer supplierOffer);

    @Named("mapToSupplierOfferResponse")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "offerId", source = "id")
    @Mapping(target = "goodInfo", source = "good", qualifiedByName = "mapToGoodDto")
    @Mapping(target = "price", source = "price")
    public abstract SupplierOfferResponseDto mapToSupplierOfferResponse(SupplierOffer supplierOffer);

    @IterableMapping(qualifiedByName = "mapToSupplierOfferResponse")
    public abstract List<SupplierOfferResponseDto> mapToSupplierOfferResponse(List<SupplierOffer> supplierOfferList);

    @Named("mapToGoodOfferResponse")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "offerId", source = "id")
    @Mapping(target = "supplierInfo", source = "supplier", qualifiedByName = "mapToSupplierDto")
    @Mapping(target = "price", source = "price")
    public abstract SupplierOfferResponseDto mapToGoodOfferResponse(SupplierOffer supplierOffer);

    @IterableMapping(qualifiedByName = "mapToGoodOfferResponse")
    public abstract List<SupplierOfferResponseDto> mapToGoodOfferResponse(List<SupplierOffer> supplierOfferList);

}
