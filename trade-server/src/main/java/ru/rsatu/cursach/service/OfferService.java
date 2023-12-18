package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.BooleanUtils;
import ru.rsatu.cursach.entity.Good;
import ru.rsatu.cursach.entity.Supplier;
import ru.rsatu.cursach.entity.SupplierOffer;
import ru.rsatu.cursach.entity.SupplierOfferPK;
import ru.rsatu.cursach.repository.SupplierOfferRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class OfferService {

    @Inject
    SupplierService supplierService;

    @Inject
    GoodService goodService;

    @Inject
    SupplierOfferRepository supplierOfferRepository;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createSupplierGoodOffer(SupplierOffer supplierOffer) {
        supplierOfferRepository.persist(supplierOffer);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void deleteSupplierGoodOffer(SupplierOfferPK supplierOfferPK) {
        SupplierOffer supplierOffer = supplierOfferRepository.findById(supplierOfferPK);
        supplierOffer.setIsActive(false);
        supplierOfferRepository.persist(supplierOffer);
    }

    public List<SupplierOffer> getSupplierOfferListBySupplierId(Long supplierId) {
        Supplier supplier = supplierService.getSupplier(supplierId);
        return Optional.ofNullable(supplier).map(Supplier::getOfferList).orElse(new ArrayList<>()).stream()
                .filter(offer -> BooleanUtils.isTrue(offer.getIsActive()))
                .collect(Collectors.toList());
    }

    public List<SupplierOffer> getSupplierOfferListByGoodId(Long goodId) {
        Good good = goodService.getGood(goodId);
        return Optional.ofNullable(good).map(Good::getOfferList).orElse(new ArrayList<>()).stream()
                .filter(offer -> BooleanUtils.isTrue(offer.getIsActive()))
                .collect(Collectors.toList());
    }
}
