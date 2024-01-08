package ru.rsatu.trade.data.dto.storage;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StorageResponseDto {

    private Long storageId;

    private String address;
    private Long volumeCapacity;
    private BigDecimal weightCapacity;

    private BigDecimal volumeUsed;
    private BigDecimal weightUsed;

    private Boolean isActive;

}
