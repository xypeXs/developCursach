package ru.rsatu.supplier.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ru.rsatu.supplier.config.MapstructConfig;
import ru.rsatu.supplier.dto.good.GoodResponseDto;

@Mapper(config = MapstructConfig.class)
public abstract class GoodMapper {

    @Named("mapToGoodDto")
    public abstract GoodResponseDto mapToGoodResponseDto(ru.rsatu.trade.data.dto.good.GoodResponseDto goodResponseDto);
}
