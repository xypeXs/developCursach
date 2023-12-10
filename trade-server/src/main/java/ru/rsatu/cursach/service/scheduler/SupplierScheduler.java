package ru.rsatu.cursach.service.scheduler;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.entity.Supplier;
import ru.rsatu.cursach.service.SupplierService;

import java.util.List;

@ApplicationScoped
public class SupplierScheduler {

    @Inject
    SupplierService supplierService;

    @Scheduled(cron = "${scheduler.supplier.rating-update-cron}")
    void updateRating() {
        List<Supplier> supplierList = supplierService.getAllSuppliers();

    }
}
