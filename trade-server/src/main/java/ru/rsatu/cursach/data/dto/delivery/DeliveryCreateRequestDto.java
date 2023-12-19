package ru.rsatu.cursach.data.dto.delivery;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DeliveryCreateRequestDto {
    @NotNull(message = "Не заполнен идентификатор склада")
    private Long storageId;
    @NotNull(message = "Не заполнен идентификатор товара")
    private Long goodId;
    @NotNull(message = "Не заполнен идентификатор поставщика")
    private Long supplierId;
    @NotNull(message = "Не заполнена дата поставки")
    @Future(message = "Недопустимая дата поставки")
    private LocalDate deliveryDate;
    @NotNull(message = "Не заполнено количество товара")
    @Min(value = 1, message = "Количество товара не может быть меньше 1")
    private Long quantity;
}
