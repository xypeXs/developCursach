package ru.rsatu.cursach.data.dto.good;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodUpdateRequestDto {

    private String name;
    private BigDecimal price;
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal length;
    private BigDecimal weight;

}
