package ru.rsatu.trade.entity.reference;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import ru.rsatu.trade.entity.base.BaseReferenceEntity;

@Entity
@Table(name = "DELIVERY_STATUSES")
@EqualsAndHashCode(callSuper = true)
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "DELIVERY_STATUS_ID"))
})
public class DeliveryStatus extends BaseReferenceEntity {
}
