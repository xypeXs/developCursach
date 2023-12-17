package ru.rsatu.cursach.model.kafka;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeliveryRequestRecord {
    private String deliveryUUID;
    private Long goodId;
    private Long storageId;
    private Long supplierId;
    private LocalDate deliveryDate;
    private Long quantity;
}
