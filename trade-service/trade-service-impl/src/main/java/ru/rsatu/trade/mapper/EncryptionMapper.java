package ru.rsatu.trade.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ru.rsatu.trade.config.MapstructConfig;
import ru.rsatu.trade.utils.EncryptionUtils;

@Mapper(
        config = MapstructConfig.class
)
public interface EncryptionMapper {

    @Named("encrypt")
    default String encryptFromLong(Long id) {
        return EncryptionUtils.encryptFromLong(id);
    }

    @Named("encrypt")
    default String encryptFromStr(String id) {
        return EncryptionUtils.encryptFromStr(id);
    }

    @Named("decrypt")
    default Long decryptToLong(String encryptedId) {
        return EncryptionUtils.decryptToLong(encryptedId);
    }

    @Named("decrypt")
    default String decryptToStr(String encryptedId) {
        return EncryptionUtils.decryptToStr(encryptedId);
    }
}
