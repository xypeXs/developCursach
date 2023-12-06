package ru.rsatu.cursach.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.cursach.config.MapstructConfig;
import ru.rsatu.cursach.data.dto.reference.BaseReferenceDto;
import ru.rsatu.cursach.entity.base.BaseReferenceEntity;

@Mapper(
        config = MapstructConfig.class,
        uses = {EncryptionMapper.class}
)
public interface ReferenceMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "code", source = "code")
    @Mapping(target = "name", source = "name")
    BaseReferenceDto mapToDto(BaseReferenceEntity entity);
}
