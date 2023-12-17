package ru.rsatu.cursach.data.dto.delivery;

import lombok.Data;
import ru.rsatu.cursach.data.dto.base.BaseReferenceDto;
import ru.rsatu.cursach.data.dto.good.GoodResponseDto;
import ru.rsatu.cursach.data.dto.storage.StorageResponseDto;
import ru.rsatu.cursach.data.dto.supplier.SupplierResponseDto;

import java.time.LocalDateTime;

@Data
public class DeliveryResponseDto {
    private StorageResponseDto storageInfo;
    private SupplierResponseDto supplierInfo;
    private GoodResponseDto goodInfo;
    private LocalDateTime deliveryDate;
    private BaseReferenceDto deliveryStatus;
}
