package ru.rsatu.trade.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StorageGoodPK implements Serializable {

    @EqualsAndHashCode.Include
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "STORAGE_ID")
    private Storage storage;

    @EqualsAndHashCode.Include
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "GOOD_ID")
    private Good good;
}
