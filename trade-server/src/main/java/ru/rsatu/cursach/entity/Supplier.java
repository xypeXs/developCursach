package ru.rsatu.cursach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.rsatu.cursach.entity.base.BaseHistoryEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "SUPPLIERS")
public class Supplier extends BaseHistoryEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "SUPPLIER_ID_SEQ")
    @SequenceGenerator(name="SUPPLIER_ID_SEQ", sequenceName="SUPPLIER_ID_SEQ", allocationSize = 1)
    @Column(name = "supplier_id")
    private Long id;

    @Column(name = "legal_address")
    private String legalAddress;

    @Column(name = "name")
    private String name;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "id.supplier", fetch = FetchType.LAZY, cascade = {})
    private List<SupplierOffer> offerList;

}
