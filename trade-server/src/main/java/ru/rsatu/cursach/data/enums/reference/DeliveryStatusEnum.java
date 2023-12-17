package ru.rsatu.cursach.data.enums.reference;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeliveryStatusEnum {

    PENDING("PENDING", "В обработке"),
    PENDING_SUPPLIER("PENDING_SUPPLIER", "На одобрении у поставщика"),
    ACCEPTED_SUPPLIER("ACCEPTED_SUPPLIER", "Принята поставщиком"),
    REJECTED_SUPPLIER("REJECTED_SUPPLIER", "Отклонена поставщиком");


    private String code;
    private String name;
}
