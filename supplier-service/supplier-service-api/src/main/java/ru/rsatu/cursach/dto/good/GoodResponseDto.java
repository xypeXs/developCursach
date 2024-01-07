package ru.rsatu.cursach.dto.good;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodResponseDto {

    private Long id;
    private String name;
    private BigDecimal height;
    private BigDecimal width;
    private BigDecimal length;
    private BigDecimal weight;
    private Boolean isActive;

}
