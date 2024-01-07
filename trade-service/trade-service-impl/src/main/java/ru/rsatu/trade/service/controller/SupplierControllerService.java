package ru.rsatu.trade.service.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.trade.data.dto.supplier.SupplierCreateRequestDto;
import ru.rsatu.trade.data.dto.supplier.SupplierResponseDto;
import ru.rsatu.trade.data.dto.supplier.SupplierUpdateRequestDto;
import ru.rsatu.trade.entity.Supplier;
import ru.rsatu.trade.mapper.SupplierMapper;
import ru.rsatu.trade.service.SupplierService;

@ApplicationScoped
public class SupplierControllerService {
    @Inject
    SupplierService supplierService;

    @Inject
    SupplierMapper supplierMapper;

    @Transactional
    public SupplierResponseDto createSupplier(SupplierCreateRequestDto createRequestDto) {
        Supplier supplier = supplierMapper.mapToSupplier(createRequestDto);
        supplierService.createSupplier(supplier);
        return supplierMapper.mapToResponse(supplier);
    }

    @Transactional
    public SupplierResponseDto getSupplier(Long id) {
        Supplier supplier = supplierService.getSupplier(id);
        return supplierMapper.mapToResponse(supplier);
    }

    @Transactional
    public SupplierResponseDto updateSupplier(Long id, SupplierUpdateRequestDto updateRequestDto) {
        Supplier srcSupplier = supplierMapper.mapToSupplier(updateRequestDto);
        supplierService.updateSupplier(id, srcSupplier);
        Supplier supplier = supplierService.getSupplier(id);
        return supplierMapper.mapToResponse(supplier);
    }

    @Transactional
    public void deleteSupplier(Long id) {
        supplierService.deleteSupplier(id);
    }
}
