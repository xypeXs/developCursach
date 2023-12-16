package ru.rsatu.cursach.data.dto.supplier;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BaseSupplierRequestDto {
    private String legalAddress;
    private String name;
    private LocalDate registrationDate;
}
