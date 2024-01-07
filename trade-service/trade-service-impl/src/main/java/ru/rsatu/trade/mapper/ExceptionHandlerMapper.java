package ru.rsatu.trade.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.trade.config.MapstructConfig;
import ru.rsatu.trade.data.dto.exception.BaseBusinessResponseDto;
import ru.rsatu.trade.exception.BaseBusinessException;

@Mapper(
        config = MapstructConfig.class
)
public abstract class ExceptionHandlerMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "message", expression = "java(exception.getMessage())")
    public abstract BaseBusinessResponseDto mapToResponseDto(BaseBusinessException exception);
}
