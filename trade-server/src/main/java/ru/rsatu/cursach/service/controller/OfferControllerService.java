package ru.rsatu.cursach.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.data.dto.offer.SupplierOfferCreateRequestDto;
import ru.rsatu.cursach.data.dto.offer.SupplierOfferResponseDto;
import ru.rsatu.cursach.entity.SupplierOffer;
import ru.rsatu.cursach.mapper.OfferMapper;
import ru.rsatu.cursach.service.OfferService;

import java.util.List;

@ApplicationScoped
public class OfferControllerService {

    @Inject
    OfferService offerService;

    @Inject
    OfferMapper offerMapper;

    @Transactional
    public SupplierOfferResponseDto createOffer(Long supplierId, Long goodId, SupplierOfferCreateRequestDto requestDto) {
        SupplierOffer supplierOffer = offerMapper.mapToSupplierOffer(supplierId, goodId, requestDto);
        offerService.createSupplierGoodOffer(supplierOffer);
        return offerMapper.mapToOfferFullResponse(supplierOffer);
    }

    @Transactional
    public void deleteOffer(Long offerId) {
        offerService.deleteSupplierGoodOffer(offerId);
    }

    @Transactional
    public List<SupplierOfferResponseDto> getSupplierOfferListBySupplier(Long supplierId) {
        List<SupplierOffer> offerList = offerService.getSupplierOfferListBySupplierId(supplierId);
        return offerMapper.mapToSupplierOfferResponse(offerList);
    }

    @Transactional
    public List<SupplierOfferResponseDto> getSupplierOfferListByGood(Long goodId) {
        List<SupplierOffer> offerList = offerService.getSupplierOfferListByGoodId(goodId);
        return offerMapper.mapToGoodOfferResponse(offerList);
    }
}
