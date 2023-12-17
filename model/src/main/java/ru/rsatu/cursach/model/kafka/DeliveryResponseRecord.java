package ru.rsatu.cursach.model.kafka;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class DeliveryResponseRecord {
    private UUID deliveryUUID;
    private String statusCode;
    private LocalDate deliveryDate;
    private Long quanity;
}
