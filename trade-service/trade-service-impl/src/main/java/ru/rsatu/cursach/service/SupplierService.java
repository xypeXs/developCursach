package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.entity.Supplier;
import ru.rsatu.cursach.mapper.SupplierMapper;
import ru.rsatu.cursach.repository.SupplierRepository;

import java.util.List;

@ApplicationScoped
public class SupplierService {

    @Inject
    SupplierRepository supplierRepository;

    @Inject
    SupplierMapper supplierMapper;

    @Transactional(Transactional.TxType.REQUIRED)
    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll().list();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void createSupplier(Supplier supplier) {
        supplierRepository.persist(supplier);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Supplier getSupplier(Long id) {
        return supplierRepository.findById(id);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void updateSupplier(Long id, Supplier srcSupplier) {
        // TODO check storages and deliveries
        Supplier updSupplier = supplierRepository.findById(id);
        supplierMapper.updateSupplier(srcSupplier, updSupplier);
        supplierRepository.persist(updSupplier);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void deleteSupplier(Long id) {
        // TODO check storages and deliveries
        Supplier supplier = supplierRepository.findById(id);
        supplier.setIsActive(false);
        supplierRepository.persist(supplier);
    }

}
