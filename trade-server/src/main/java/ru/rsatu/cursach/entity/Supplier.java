package ru.rsatu.cursach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.rsatu.cursach.entity.base.BaseHistoryEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "SUPPLIERS")
public class Supplier extends BaseHistoryEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SUPPLIER_ID_SEQ")
    @Column(name = "supplier_id")
    private Long id;

    @Column(name = "legal_address")
    private String legalAddress;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @Column(name = "rating")
    private BigDecimal rating;

}
