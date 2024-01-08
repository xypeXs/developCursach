package ru.rsatu.supplier.dto.delivery;

import lombok.Data;
import ru.rsatu.supplier.dto.good.GoodResponseDto;
import ru.rsatu.supplier.dto.reference.BaseReferenceDto;
import ru.rsatu.supplier.dto.storage.StorageResponseDto;
import ru.rsatu.supplier.dto.supplier.SupplierResponseDto;

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
