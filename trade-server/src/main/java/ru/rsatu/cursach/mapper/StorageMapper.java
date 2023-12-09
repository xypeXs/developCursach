package ru.rsatu.cursach.mapper;

import jakarta.inject.Inject;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.rsatu.cursach.config.MapstructConfig;
import ru.rsatu.cursach.data.dto.storage.StorageCreateRequestDto;
import ru.rsatu.cursach.data.dto.storage.StorageResponseDto;
import ru.rsatu.cursach.data.dto.storage.StorageUpdateRequestDto;
import ru.rsatu.cursach.entity.Storage;
import ru.rsatu.cursach.service.StorageService;

@Mapper(
        config = MapstructConfig.class
)
public abstract class StorageMapper {

    @Inject
    StorageService storageService;

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "address", source = "address")
    @Mapping(target = "volumeCapacity", source = "volumeCapacity")
    @Mapping(target = "weightCapacity", source = "weightCapacity")
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

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "storageId", source = "storageId")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "volumeCapacity", source = "volumeCapacity")
    @Mapping(target = "weightCapacity", source = "weightCapacity")
    @Mapping(target = "volumeUsed", expression = "java(storageService.computeVolumeUsed(storage))")
    @Mapping(target = "weightUsed", expression = "java(storageService.computeWeightUsed(storage))")
    public abstract StorageResponseDto mapToResponse(Storage storage);
}
