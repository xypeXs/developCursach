package ru.rsatu.trade.mapper;

import jakarta.inject.Inject;
import org.mapstruct.BeanMapping;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import ru.rsatu.trade.config.MapstructConfig;
import ru.rsatu.trade.data.dto.storage.StorageCreateRequestDto;
import ru.rsatu.trade.data.dto.storage.StorageGoodResponseDto;
import ru.rsatu.trade.data.dto.storage.StorageResponseDto;
import ru.rsatu.trade.data.dto.storage.StorageUpdateRequestDto;
import ru.rsatu.trade.entity.Storage;
import ru.rsatu.trade.entity.StorageGood;
import ru.rsatu.trade.service.StorageService;

import java.util.List;

@Mapper(
        config = MapstructConfig.class,
        uses = {GoodMapper.class}
)
public abstract class StorageMapper {

    @Inject
    StorageService storageService;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "address", source = "address")
    @Mapping(target = "volumeCapacity", source = "volumeCapacity")
    @Mapping(target = "weightCapacity", source = "weightCapacity")
    @Mapping(target = "isActive", expression = "java(true)")
    public abstract Storage mapToStorage(StorageCreateRequestDto createRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "address", source = "address")
    @Mapping(target = "volumeCapacity", source = "volumeCapacity")
    @Mapping(target = "weightCapacity", source = "weightCapacity")
    public abstract Storage mapToStorage(StorageUpdateRequestDto updateRequestDto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "address", source = "address")
    @Mapping(target = "volumeCapacity", source = "volumeCapacity")
    @Mapping(target = "weightCapacity", source = "weightCapacity")
    public abstract void updateStorage(Storage src, @MappingTarget Storage upd);

    @Named("mapToStorageDto")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "storageId", source = "storageId")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "volumeCapacity", source = "volumeCapacity")
    @Mapping(target = "weightCapacity", source = "weightCapacity")
    @Mapping(target = "volumeUsed", expression = "java(storageService.computeVolumeUsed(storage))")
    @Mapping(target = "weightUsed", expression = "java(storageService.computeWeightUsed(storage))")
    @Mapping(target = "isActive", source = "isActive")
    public abstract StorageResponseDto mapToResponse(Storage storage);

    @Named("mapToStorageGoodDto")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "goodInfo", source = "storageGoodId.good", qualifiedByName = "mapToGoodDto")
    @Mapping(target = "quantity", source = "quantity")
    public abstract StorageGoodResponseDto mapToStorageGoodResponse(StorageGood storageGood);

    @IterableMapping(qualifiedByName = "mapToStorageGoodDto")
    public abstract List<StorageGoodResponseDto> mapToStorageGoodResponse(List<StorageGood> storageGood);
}
