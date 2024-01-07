package ru.rsatu.trade.data.dto.storage;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import ru.rsatu.trade.data.validation.controller.Validation;

import java.math.BigDecimal;

@Data
public class BaseStorageRequestDto {

    @NotNull(message = Validation.Message.STORAGE_ADDRESS_NULL)
    @Pattern(regexp = Validation.Pattern.STORAGE_ADDRESS,
            message = Validation.Message.STORAGE_ADDRESS_NOT_VALID)
    private String address;

    @NotNull(message = Validation.Message.STORAGE_VOLUME_CAPACITY_NULL)
    @Min(value = 1, message = Validation.Message.STORAGE_VOLUME_CAPACITY_NOT_VALID)
    private Long volumeCapacity;

    @NotNull(message = Validation.Message.STORAGE_WEIGHT_CAPACITY_NULL)
    @Positive(message = Validation.Message.STORAGE_WEIGHT_CAPACITY_NOT_VALID)
    private BigDecimal weightCapacity;
}
