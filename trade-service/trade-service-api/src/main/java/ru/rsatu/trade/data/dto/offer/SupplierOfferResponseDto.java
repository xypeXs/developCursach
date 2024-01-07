package ru.rsatu.trade.data.dto.offer;

import lombok.Data;
import ru.rsatu.trade.data.dto.good.GoodResponseDto;
import ru.rsatu.trade.data.dto.supplier.SupplierResponseDto;

import java.math.BigDecimal;

@Data
public class SupplierOfferResponseDto {
    private Long offerId;
    private GoodResponseDto goodInfo;
    private SupplierResponseDto supplierInfo;
    private BigDecimal price;
}

