package ru.rsatu.trade.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "STORAGE_REL_GOOD")
public class StorageGood {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private StorageGoodPK storageGoodId;

    private Long quantity;

    public static StorageGood empty(StorageGoodPK storageGoodPK) {
        StorageGood storageGood = new StorageGood();
        storageGood.setStorageGoodId(storageGoodPK);
        storageGood.setQuantity(0L);
        return storageGood;
    }
}
