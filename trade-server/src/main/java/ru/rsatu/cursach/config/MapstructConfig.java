package ru.rsatu.cursach.config;

import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueMappingStrategy;

@MapperConfig(
        componentModel = "cdi",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT
)
public class MapstructConfig {
}
