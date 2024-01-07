package ru.rsatu.supplier.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.rsatu.supplier.config.MapstructConfig;
import ru.rsatu.supplier.dto.reference.BaseReferenceDto;
import ru.rsatu.supplier.entity.base.BaseReferenceEntity;

import java.util.List;

@Mapper(
        config = MapstructConfig.class
)
public interface ReferenceMapper {

    @Named("referenceBase")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "code", source = "code")
    @Mapping(target = "name", source = "name")
    BaseReferenceDto mapToDto(BaseReferenceEntity entity);

    @IterableMapping(qualifiedByName = "referenceBase")
    List<BaseReferenceDto> mapToDtoList(List<BaseReferenceEntity> entityList);
}
