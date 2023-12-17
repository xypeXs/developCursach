package ru.rsatu.cursach.entity;

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
import ru.rsatu.cursach.entity.reference.DeliveryStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "DELIVERIES")
public class Delivery {

    @Id
    @GeneratedValue(generator = "DELIVERY_ID_SEQ")
    @SequenceGenerator(name="DELIVERY_ID_SEQ", sequenceName="DELIVERY_ID_SEQ", allocationSize = 1)
    @EqualsAndHashCode.Include
    @Column(name = "DELIVERY_ID")
    private Long id;

    @Column(name = "UUID")
    private UUID uuid;

    @Column(name = "SUPPLIER_ID")
    private Long supplierId;

    @Column(name = "GOOD_ID")
    private Long goodId;

    @Column(name = "STORAGE_ID")
    private Long storageId;

    @Column(name = "DELIVERY_DATE")
    private LocalDate deliveryDate;

    @Column(name = "RATING")
    private BigDecimal rating;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "DELIVERY_STATUS_ID")
    private DeliveryStatus status;

}