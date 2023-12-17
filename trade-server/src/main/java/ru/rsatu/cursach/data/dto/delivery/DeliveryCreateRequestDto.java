package ru.rsatu.cursach.data.dto.delivery;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeliveryCreateRequestDto {
    private Long storageId;
    private Long goodId;
    private Long supplierId;
    private LocalDate deliveryDate;
    private Long quantity;
}
