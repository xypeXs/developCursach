package ru.rsatu.model.kafka;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DeliveryResponseRecord {
    private String deliveryUUID;
    private String statusCode;
    private LocalDate deliveryDate;
    private Long quantity;
}
