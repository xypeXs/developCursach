package ru.rsatu.trade.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import ru.rsatu.trade.config.MapstructConfig;
import ru.rsatu.trade.data.dto.good.GoodCreateRequestDto;
import ru.rsatu.trade.data.dto.good.GoodResponseDto;
import ru.rsatu.trade.data.dto.good.GoodUpdateRequestDto;
import ru.rsatu.trade.entity.Good;

@Mapper(
        config = MapstructConfig.class
)
public abstract class GoodMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "length", source = "length")
    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "isActive", expression = "java(true)")
    public abstract Good mapToGood(GoodCreateRequestDto createRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "length", source = "length")
    @Mapping(target = "weight", source = "weight")
    public abstract Good mapToGood(GoodUpdateRequestDto updateRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "length", source = "length")
    @Mapping(target = "weight", source = "weight")
    public abstract void updateGood(Good src, @MappingTarget Good upd);

    @Named("mapToGoodDto")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "goodId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "height", source = "height")
    @Mapping(target = "width", source = "width")
    @Mapping(target = "length", source = "length")
    @Mapping(target = "weight", source = "weight")
    @Mapping(target = "isActive", source = "isActive")
    public abstract GoodResponseDto mapToResponse(Good good);
}
