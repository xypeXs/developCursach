package ru.rsatu.cursach.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.rsatu.cursach.data.dto.reference.BaseReferenceDto;
import ru.rsatu.cursach.entity.base.BaseReferenceEntity;

@Mapper(
        uses = {EncryptionMapper.class}
)
public interface ReferenceMapper {

    @Mapping(target = "id", source = "id", qualifiedByName = "encrypt")
    @Mapping(target = "name", source = "name")
    BaseReferenceDto mapToDto(BaseReferenceEntity entity);
}
