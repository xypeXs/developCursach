package ru.rsatu.cursach.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import ru.rsatu.cursach.entity.Supplier;
import ru.rsatu.cursach.repository.SupplierRepository;

import java.util.List;

@ApplicationScoped
public class SupplierService {

    @Inject
    SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll().list();
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void updateRating(Supplier supplier) {
    }

}
