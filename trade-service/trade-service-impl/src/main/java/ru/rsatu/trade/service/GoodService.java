package ru.rsatu.trade.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.trade.entity.Good;
import ru.rsatu.trade.mapper.GoodMapper;
import ru.rsatu.trade.repository.GoodRepository;

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

    @Transactional(Transactional.TxType.REQUIRED)
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
    public void deleteGood(Long id) {
        // TODO check storages and deliveries
        Good good = goodRepository.findById(id);
        good.setIsActive(false);
        goodRepository.persist(good);
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
