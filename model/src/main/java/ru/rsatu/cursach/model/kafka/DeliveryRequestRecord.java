package ru.rsatu.cursach.model.kafka;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class DeliveryRequestRecord {
    private UUID deliveryUUID;
    private Long goodId;
    private Long storageId;
    private Long supplierId;
    private LocalDate deliveryDate;
    private Long quanity;
}
