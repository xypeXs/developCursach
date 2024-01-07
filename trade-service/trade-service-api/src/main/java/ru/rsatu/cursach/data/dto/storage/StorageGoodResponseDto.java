package ru.rsatu.cursach.data.dto.storage;

import lombok.Data;
import ru.rsatu.cursach.data.dto.good.GoodResponseDto;

@Data
public class StorageGoodResponseDto {
    private GoodResponseDto goodInfo;
    private Long quantity;
}
