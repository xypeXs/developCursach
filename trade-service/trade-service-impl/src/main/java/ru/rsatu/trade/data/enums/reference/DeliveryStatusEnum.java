package ru.rsatu.trade.data.enums.reference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import ru.rsatu.trade.entity.reference.DeliveryStatus;

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

    private String code;
    private String name;

    public static boolean equals(DeliveryStatusEnum statusEnum, DeliveryStatus deliveryStatus) {
        if (deliveryStatus == null || statusEnum == null)
            return false;
        return StringUtils.equals(statusEnum.getCode(), deliveryStatus.getCode());
    }
}
