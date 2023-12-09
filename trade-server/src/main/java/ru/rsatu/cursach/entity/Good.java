package ru.rsatu.cursach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "GOODS")
public class Good {

    @Id
    @EqualsAndHashCode.Include
    @Column(name = "good_id")
    private Long goodId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "volume")
    private Long volume;

    @Column(name = "weight")
    private BigDecimal weight;

    @OneToMany(mappedBy = "storageGoodId.good", fetch = FetchType.LAZY, cascade = {})
    private List<StorageGood> storageGoodList;
}
