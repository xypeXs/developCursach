package ru.rsatu.cursach.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.rsatu.cursach.config.MapstructConfig;
import ru.rsatu.cursach.data.dto.good.GoodCreateRequestDto;
import ru.rsatu.cursach.data.dto.good.GoodResponseDto;
import ru.rsatu.cursach.data.dto.good.GoodUpdateRequestDto;
import ru.rsatu.cursach.entity.Good;

@Mapper(
        config = MapstructConfig.class
)
public abstract class GoodMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "length", source = "length")
    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "isActive", expression = "java(true)")
    public abstract Good mapToGood(GoodCreateRequestDto createRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "length", source = "length")
    @Mapping(target = "weight", source = "weight")
    public abstract Good mapToGood(GoodUpdateRequestDto updateRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "length", source = "length")
    @Mapping(target = "weight", source = "weight")
    public abstract void updateGood(Good src, @MappingTarget Good upd);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "goodId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "length", source = "length")
    @Mapping(target = "weight", source = "weight")
    public abstract GoodResponseDto mapToResponse(Good good);
}
