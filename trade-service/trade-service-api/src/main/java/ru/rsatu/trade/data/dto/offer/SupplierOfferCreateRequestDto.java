package ru.rsatu.trade.data.dto.offer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import ru.rsatu.trade.data.validation.controller.Validation;

import java.math.BigDecimal;

@Data
public class SupplierOfferCreateRequestDto {
    @NotNull(message = Validation.Message.OFFER_PRICE_NULL)
    @Positive(message = Validation.Message.OFFER_PRICE_NOT_VALID)
    private BigDecimal price;
}
