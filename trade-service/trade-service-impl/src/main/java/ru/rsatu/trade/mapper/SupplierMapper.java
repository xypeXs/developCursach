package ru.rsatu.trade.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import ru.rsatu.trade.config.MapstructConfig;
import ru.rsatu.trade.data.dto.supplier.SupplierCreateRequestDto;
import ru.rsatu.trade.data.dto.supplier.SupplierResponseDto;
import ru.rsatu.trade.data.dto.supplier.SupplierUpdateRequestDto;
import ru.rsatu.trade.entity.Supplier;

import java.math.BigDecimal;

@Mapper(
        config = MapstructConfig.class,
        imports = {BigDecimal.class}
)
public abstract class SupplierMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "legalAddress", source = "legalAddress")
    @Mapping(target = "registrationDate", source = "registrationDate")
    @Mapping(target = "isActive", expression = "java(true)")
    public abstract Supplier mapToSupplier(SupplierCreateRequestDto createRequestDto);

    @Named("mapToSupplierDto")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "legalAddress", source = "legalAddress")
    @Mapping(target = "registrationDate", source = "registrationDate")
    @Mapping(target = "isActive", source = "isActive")
    public abstract SupplierResponseDto mapToResponse(Supplier supplier);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "legalAddress", source = "legalAddress")
    @Mapping(target = "registrationDate", source = "registrationDate")
    public abstract Supplier mapToSupplier(SupplierUpdateRequestDto updateRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "legalAddress", source = "legalAddress")
    @Mapping(target = "registrationDate", source = "registrationDate")
    public abstract void updateSupplier(Supplier src, @MappingTarget Supplier upd);
}
