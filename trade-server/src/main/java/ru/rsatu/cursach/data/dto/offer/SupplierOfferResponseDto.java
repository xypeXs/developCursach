package ru.rsatu.cursach.data.dto.offer;

import lombok.Data;
import ru.rsatu.cursach.data.dto.good.GoodResponseDto;
import ru.rsatu.cursach.data.dto.supplier.SupplierResponseDto;

import java.math.BigDecimal;

@Data
public class SupplierOfferResponseDto {
    private GoodResponseDto goodInfo;
    private SupplierResponseDto supplierInfo;
    private BigDecimal rating;
}

