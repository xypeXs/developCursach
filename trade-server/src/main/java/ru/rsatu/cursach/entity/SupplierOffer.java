package ru.rsatu.cursach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.rsatu.cursach.entity.base.BaseHistoryEntity;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "SUPPLIER_OFFERS")
public class SupplierOffer extends BaseHistoryEntity {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private SupplierOfferPK id;

    @Column(name = "RATING")
    private BigDecimal rating;

}
