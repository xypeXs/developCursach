package ru.rsatu.cursach.data.dto.delivery;

import lombok.Data;
import ru.rsatu.cursach.data.dto.good.GoodResponseDto;
import ru.rsatu.cursach.data.dto.reference.BaseReferenceDto;
import ru.rsatu.cursach.data.dto.storage.StorageResponseDto;
import ru.rsatu.cursach.data.dto.supplier.SupplierResponseDto;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class DeliveryResponseDto {
    private String uuid;
    private StorageResponseDto storageInfo;
    private SupplierResponseDto supplierInfo;
    private GoodResponseDto goodInfo;
    private LocalDate deliveryDate;
    private BaseReferenceDto deliveryStatus;
    private Long quantity;
    private BigDecimal price;
}
