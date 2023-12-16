package ru.rsatu.cursach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import ru.rsatu.cursach.entity.base.BaseHistoryEntity;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "GOODS")
public class Good extends BaseHistoryEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "GOOD_ID_SEQ")
    @Column(name = "good_id")
    private Long goodId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "width")
    private BigDecimal width;

    @Column(name = "length")
    private BigDecimal length;

    @Column(name = "weight")
    private BigDecimal weight;

    @OneToMany(mappedBy = "storageGoodId.good", fetch = FetchType.LAZY, cascade = {})
    private List<StorageGood> storageGoodList;

    @OneToMany(mappedBy = "id.good", fetch = FetchType.LAZY, cascade = {})
    private List<SupplierOffer> offerList;
}
