package ru.rsatu.cursach.data.dto.storage;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class StorageUpdateRequestDto {

    private String address;
    private Long volumeCapacity;
    private BigDecimal weightCapacity;
}
