package ru.rsatu.cursach.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.cursach.config.MapstructConfig;
import ru.rsatu.cursach.data.dto.exception.BaseBusinessResponseDto;
import ru.rsatu.cursach.exception.BaseBusinessException;

@Mapper(
        config = MapstructConfig.class
)
public abstract class ExceptionHandlerMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "message", expression = "java(exception.getMessage())")
    public abstract BaseBusinessResponseDto mapToResponseDto(BaseBusinessException exception);
}
