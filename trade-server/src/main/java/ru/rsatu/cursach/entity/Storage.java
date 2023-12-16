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
@Table(name = "STORAGES")
public class Storage extends BaseHistoryEntity {

    @Id
    @GeneratedValue(generator = "STORAGE_ID_SEQ")
    @EqualsAndHashCode.Include
    @Column(name = "STORAGE_ID")
    private Long storageId;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "volume_capacity")
    private Long volumeCapacity;

    @Column(name = "weight_capacity")
    private BigDecimal weightCapacity;

    @OneToMany(mappedBy = "storageGoodId.storage", fetch = FetchType.LAZY, cascade = {})
    private List<StorageGood> storageGoodList;
}
