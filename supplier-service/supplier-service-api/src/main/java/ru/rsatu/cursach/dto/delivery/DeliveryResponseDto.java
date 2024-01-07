package ru.rsatu.cursach.dto.delivery;

import lombok.Data;
import ru.rsatu.cursach.dto.good.GoodResponseDto;
import ru.rsatu.cursach.dto.reference.BaseReferenceDto;
import ru.rsatu.cursach.dto.storage.StorageResponseDto;
import ru.rsatu.cursach.dto.supplier.SupplierResponseDto;

import java.time.LocalDate;

@Data
public class DeliveryResponseDto {
    private String uuid;
    private GoodResponseDto goodInfo;
    private StorageResponseDto storageInfo;
    private SupplierResponseDto supplierInfo;
    private LocalDate deliveryDate;
    private BaseReferenceDto deliveryStatus;
    private Long quantity;
}
