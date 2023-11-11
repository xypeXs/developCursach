package ru.rsatu.cursach.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "GOOD_TYPES")
@AttributeOverride(name = "id", column = @Column(name = "GOOD_TYPE_ID"))
@AttributeOverride(name = "name", column = @Column(name = "NAME"))
public class GoodType extends BaseReferenceEntity {
}
