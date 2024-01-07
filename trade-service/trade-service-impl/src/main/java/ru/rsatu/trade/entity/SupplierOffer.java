package ru.rsatu.trade.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.rsatu.trade.entity.base.BaseHistoryEntity;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "SUPPLIER_OFFERS")
public class SupplierOffer extends BaseHistoryEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SUPPLIER_OFFER_ID_SEQ")
    @SequenceGenerator(name="SUPPLIER_OFFER_ID_SEQ", sequenceName="SUPPLIER_OFFER_ID_SEQ", allocationSize = 1)
    @Column(name = "SUPPLIER_OFFER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "GOOD_ID")
    private Good good;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;

    @Column(name = "PRICE")
    private BigDecimal price;

}
