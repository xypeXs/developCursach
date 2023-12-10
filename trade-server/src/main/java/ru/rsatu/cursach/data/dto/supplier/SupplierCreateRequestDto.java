package ru.rsatu.cursach.data.dto.supplier;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class SupplierCreateRequestDto {

    private String legalAddress;
    private String name;
    private LocalDate registrationDate;
    private BigDecimal rating;
}
