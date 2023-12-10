package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.entity.Good;
import ru.rsatu.cursach.mapper.GoodMapper;
import ru.rsatu.cursach.repository.GoodRepository;

import java.math.BigDecimal;

@ApplicationScoped
public class GoodService {

    @Inject
    GoodRepository goodRepository;

    @Inject
    GoodMapper goodMapper;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createGood(Good good) {
        goodRepository.persist(good);
    }

    public Good getGood(Long id) {
        return goodRepository.findById(id);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void updateGood(Long id, Good srcGood) {
        // TODO check storages and deliveries
        Good updGood = goodRepository.findById(id);
        goodMapper.updateGood(srcGood, updGood);
        goodRepository.persist(updGood);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void deleteGood(Good good) {
        // TODO check storages and deliveries
        goodRepository.delete(good);
    }

    public BigDecimal computeVolume(Good good) {
        return good.getWeight()
                .multiply(good.getHeight())
                .multiply(good.getLength());
    }

    public BigDecimal computeWeight(Good good) {
        return good.getWeight();
    }
}
