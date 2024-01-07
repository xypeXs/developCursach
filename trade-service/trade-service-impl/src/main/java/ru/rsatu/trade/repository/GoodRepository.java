package ru.rsatu.trade.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.trade.entity.Good;

@ApplicationScoped
public class GoodRepository implements PanacheRepositoryBase<Good, Long> {
}
