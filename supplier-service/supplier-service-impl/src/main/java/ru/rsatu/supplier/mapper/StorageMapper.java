package ru.rsatu.supplier.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ru.rsatu.supplier.config.MapstructConfig;
import ru.rsatu.supplier.dto.storage.StorageResponseDto;

@Mapper(config = MapstructConfig.class)
public abstract class StorageMapper {
    @Named("mapToStorageDto")
    public abstract StorageResponseDto mapToGoodResponseDto(ru.rsatu.trade.data.dto.storage.StorageResponseDto storageResponseDto);
}
