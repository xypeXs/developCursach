package ru.rsatu.cursach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.rsatu.cursach.entity.reference.DeliveryStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "DELIVERIES")
public class Delivery {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "DELIVERY_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "GOOD_ID")
    private Good good;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "STORAGE_ID")
    private Storage storage;

    @Column(name = "DELIVERY_DATE")
    private LocalDate deliveryDate;

    @Column(name = "RATING")
    private BigDecimal rating;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "DELIVERY_STATUS_ID")
    private DeliveryStatus status;

}