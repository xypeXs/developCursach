package ru.rsatu.trade.entity.base;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseHistoryEntity {

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

}
