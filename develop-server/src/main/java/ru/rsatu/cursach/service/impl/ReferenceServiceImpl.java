package ru.rsatu.cursach.service.impl;

import jakarta.transaction.Transactional;
import ru.rsatu.cursach.entity.GoodType;
import ru.rsatu.cursach.repository.reference.GoodTypeRepository;
import ru.rsatu.cursach.service.ReferenceService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ReferenceServiceImpl implements ReferenceService {

    private final GoodTypeRepository goodTypeRepository;

    @Inject
    public ReferenceServiceImpl(GoodTypeRepository goodTypeRepository) {
        this.goodTypeRepository = goodTypeRepository;
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveGoodType(GoodType goodType) {
        goodTypeRepository.save(goodType);
    }

    public GoodType getGoodType(Long id) {
        return goodTypeRepository.findById(id).orElse(null);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void deleteGoodType(Long id) {
        goodTypeRepository.deleteById(id);
    }
}
