package ru.rsatu.cursach.model.kafka;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeliveryRequestRecord {
    private String deliveryUUID;
    private Long storageId;
    private LocalDate deliveryDate;
    private Long quantity;
    private Long supplierOfferId;
}
