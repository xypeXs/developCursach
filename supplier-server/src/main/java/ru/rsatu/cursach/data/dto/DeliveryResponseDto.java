package ru.rsatu.cursach.data.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeliveryResponseDto {
    private String uuid;
    private LocalDate deliveryDate;
    private BaseReferenceDto deliveryStatus;
    private Long quantity;
}
