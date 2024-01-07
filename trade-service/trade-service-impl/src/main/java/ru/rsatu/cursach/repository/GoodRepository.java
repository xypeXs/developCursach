package ru.rsatu.cursach.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import ru.rsatu.cursach.entity.Good;

@ApplicationScoped
public class GoodRepository implements PanacheRepositoryBase<Good, Long> {
}
