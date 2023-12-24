package ru.rsatu.cursach.data.dto.supplier;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import ru.rsatu.cursach.data.validation.controller.Validation;

import java.time.LocalDate;

@Data
public class BaseSupplierRequestDto {

    @NotNull(message = Validation.Message.SUPPLIER_LEGAL_ADDRESS_NULL)
    @Pattern(regexp = Validation.Pattern.SUPPLIER_LEGAL_ADDRESS,
            message = Validation.Message.SUPPLIER_LEGAL_ADDRESS_NOT_VALID)
    private String legalAddress;

    @NotNull(message = Validation.Message.SUPPLIER_NAME_NULL)
    @Pattern(regexp = Validation.Pattern.SUPPLIER_NAME,
            message = Validation.Message.SUPPLIER_NAME_NOT_VALID)
    private String name;

    @NotNull(message = Validation.Message.SUPPLIER_REG_DATE_NULL)
    @Past(message = Validation.Message.SUPPLIER_REG_DATE_NOT_VALID)
    private LocalDate registrationDate;
}
