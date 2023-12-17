package ru.rsatu.cursach.service.scheduler;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.cursach.data.reference.DeliveryStatusEnum;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.service.DeliveryService;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class SupplierScheduler {

    @Inject
    DeliveryService deliveryService;

    @Scheduled(cron = "${scheduler.delivery-request-process.cron}")
    void processDeliveryRequest() {
        List<Delivery> pendingDeliveryList = deliveryService.getDeliveriesByStatus(DeliveryStatusEnum.PENDING_SUPPLIER);
        List<Delivery> processedDeliveries = pendingDeliveryList.stream()
                .map(deliveryService::processDelivery)
                .collect(Collectors.toList());
        deliveryService.saveAll(processedDeliveries);
        processedDeliveries.forEach(deliveryService::sendDeliveryResponse);
    }
}
