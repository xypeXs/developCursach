package ru.rsatu.cursach.data.dto.delivery;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ru.rsatu.cursach.data.validation.controller.Validation;

import java.time.LocalDate;

@Data
public class DeliveryCreateRequestDto {

    @NotNull(message = Validation.Message.STORAGE_ID_NULL)
    private Long storageId;

    @NotNull(message = Validation.Message.GOOD_ID_NULL)
    private Long goodId;

    @NotNull(message = Validation.Message.SUPPLIER_ID_NULL)
    private Long supplierId;

    @NotNull(message = Validation.Message.DELIVERY_DATE_NULL)
    @FutureOrPresent(message = Validation.Message.DELIVERY_DATE_NOT_VALID)
    private LocalDate deliveryDate;

    @NotNull(message = Validation.Message.GOOD_QUANTITY_NULL)
    @Min(value = 1, message = Validation.Message.GOOD_QUANTITY_NOT_VALID)
    private Long quantity;
}
