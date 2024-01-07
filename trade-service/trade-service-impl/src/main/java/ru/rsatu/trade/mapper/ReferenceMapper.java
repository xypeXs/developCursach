package ru.rsatu.trade.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.rsatu.trade.config.MapstructConfig;
import ru.rsatu.trade.data.dto.reference.BaseReferenceDto;
import ru.rsatu.trade.data.dto.reference.BaseReferencePageDto;
import ru.rsatu.trade.entity.base.BaseReferenceEntity;

import java.util.List;
import java.util.stream.Collectors;

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

    @IterableMapping(qualifiedByName = "referenceBase")
    List<BaseReferenceDto> mapToDtoList(List<BaseReferenceEntity> entityList);

    default <E extends BaseReferenceEntity> BaseReferencePageDto mapToPageDto(List<E> entitiyList, Long total) {
        if (entitiyList == null)
            return BaseReferencePageDto.empty();

        List<BaseReferenceEntity> baseReferenceEntityList = entitiyList.stream()
                .map(e -> (BaseReferenceEntity) e)
                .collect(Collectors.toList());

        List<BaseReferenceDto> referenceDtoList = mapToDtoList(baseReferenceEntityList);
        return new BaseReferencePageDto(referenceDtoList, total);
    }
}
