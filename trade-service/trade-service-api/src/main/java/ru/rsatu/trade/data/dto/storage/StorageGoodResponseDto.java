package ru.rsatu.trade.data.dto.storage;

import lombok.Data;
import ru.rsatu.trade.data.dto.good.GoodResponseDto;

@Data
public class StorageGoodResponseDto {
    private GoodResponseDto goodInfo;
    private Long quantity;
}
