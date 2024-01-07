package ru.rsatu.cursach.data.reference;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DeliveryStatusEnum {

    PENDING("PENDING", "В обработке"),
    PENDING_SUPPLIER("PENDING_SUPPLIER", "На одобрении у поставщика"),
    ACCEPTED_SUPPLIER("ACCEPTED_SUPPLIER", "Принята поставщиком"),
    REJECTED_SUPPLIER("REJECTED_SUPPLIER", "Отклонена поставщиком"),
    ON_WAY("ON_WAY", "В пути"),
    DELIVERED("DELIVERED", "Доставлено")

    ;

    private final String code;
    private final String name;
}
