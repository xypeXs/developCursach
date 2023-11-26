package ru.rsatu.cursach.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import ru.rsatu.cursach.utils.EncryptionUtils;

@Mapper
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
