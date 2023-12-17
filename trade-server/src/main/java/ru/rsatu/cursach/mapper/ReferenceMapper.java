package ru.rsatu.cursach.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.rsatu.cursach.config.MapstructConfig;
import ru.rsatu.cursach.data.dto.reference.BaseReferenceDto;
import ru.rsatu.cursach.data.dto.reference.BaseReferencePageDto;
import ru.rsatu.cursach.entity.base.BaseReferenceEntity;

import java.util.List;

@Mapper(
        config = MapstructConfig.class,
        uses = {EncryptionMapper.class}
)
public interface ReferenceMapper {

    @Named("referenceBase")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "code", source = "code")
    @Mapping(target = "name", source = "name")
    BaseReferenceDto mapToDto(BaseReferenceEntity entity);

    @IterableMapping(qualifiedByName = )
    List<BaseReferenceDto> mapToDtoList(List<BaseReferenceEntity> entityList);

    default BaseReferencePageDto mapToPageDto(List<BaseReferenceEntity> entitiyList, Long total) {
        if (entitiyList == null)
            return BaseReferencePageDto.empty();
        List<BaseReferenceDto> referenceDtoList = mapToDtoList(entitiyList);
        return new BaseReferencePageDto(referenceDtoList, total);
    }
}
