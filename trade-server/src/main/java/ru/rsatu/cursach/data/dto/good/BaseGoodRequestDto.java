package ru.rsatu.cursach.data.dto.good;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import ru.rsatu.cursach.data.validation.controller.Validation;

import java.math.BigDecimal;

@Data
public class BaseGoodRequestDto {

    @NotNull(message = Validation.Message.GOOD_NAME_NULL)
    @Pattern(regexp = Validation.Pattern.GOOD_NAME,
            message = Validation.Message.GOOD_NAME_NOT_VALID)
    private String name;

    @NotNull(message = Validation.Message.GOOD_PRICE_NULL)
    @Positive(message = Validation.Message.GOOD_PRICE_NOT_VALID)
    private BigDecimal price;

    @NotNull(message = Validation.Message.GOOD_HEIGHT_NULL)
    @Positive(message = Validation.Message.GOOD_HEIGHT_NOT_VALID)
    private BigDecimal height;

    @NotNull(message = Validation.Message.GOOD_WIDTH_NULL)
    @Positive(message = Validation.Message.GOOD_WIDTH_NOT_VALID)
    private BigDecimal width;

    @NotNull(message = Validation.Message.GOOD_LENGTH_NULL)
    @Positive(message = Validation.Message.GOOD_LENGTH_NOT_VALID)
    private BigDecimal length;

    @NotNull(message = Validation.Message.GOOD_WEIGHT_NULL)
    @Positive(message = Validation.Message.GOOD_WEIGHT_NOT_VALID)
    private BigDecimal weight;
}
