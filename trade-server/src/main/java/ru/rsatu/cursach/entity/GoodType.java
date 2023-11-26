package ru.rsatu.cursach.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import ru.rsatu.cursach.entity.base.BaseReferenceEntity;

@Entity
@Table(name = "GOOD_TYPES")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "GOOD_TYPE_ID"))
})
public class GoodType extends BaseReferenceEntity {
}
