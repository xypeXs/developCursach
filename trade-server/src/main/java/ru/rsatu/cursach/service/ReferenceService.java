package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.entity.GoodType;
import ru.rsatu.cursach.repository.GoodTypeRepository;

@ApplicationScoped
public class ReferenceService {

    @Inject
    GoodTypeRepository goodTypeRepository;

    public GoodType getGoodType(Long id) {
        return goodTypeRepository.findById(id);
    }
}
