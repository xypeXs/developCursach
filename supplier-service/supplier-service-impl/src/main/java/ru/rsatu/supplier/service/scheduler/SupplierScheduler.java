package ru.rsatu.supplier.service.scheduler;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import ru.rsatu.supplier.data.reference.DeliveryStatusEnum;
import ru.rsatu.supplier.entity.Delivery;
import ru.rsatu.supplier.service.DeliveryService;
import ru.rsatu.supplier.service.ReferenceService;

import java.util.List;

@ApplicationScoped
public class SupplierScheduler {

    @Inject
    DeliveryService deliveryService;

    @Inject
    ReferenceService referenceService;


    @Scheduled(cron = "${scheduler.delivery.process-request.cron}", concurrentExecution = Scheduled.ConcurrentExecution.SKIP)
    void processDeliveryRequests() {
        List<Delivery> processedDeliveryRequestList = deliveryService.processDeliveryRequests();
        processedDeliveryRequestList.forEach(deliveryService::sendDeliveryResponse);
    }


    @Scheduled(cron = "${scheduler.delivery.proceed-accepted-status.cron}", concurrentExecution = Scheduled.ConcurrentExecution.SKIP)
    void processAcceptedDeliveries() {
        List<Delivery> processedDeliveryList = deliveryService.processAcceptedDeliveries(DeliveryStatusEnum.ACCEPTED_SUPPLIER, DeliveryStatusEnum.ON_WAY);
        processedDeliveryList.forEach(deliveryService::sendDeliveryResponse);
    }

    @Scheduled(cron = "${scheduler.delivery.proceed-moving-status.cron}", concurrentExecution = Scheduled.ConcurrentExecution.SKIP)
    void processMovingDeliveries() {
        List<Delivery> processedDeliveryList =
                deliveryService.processMovingDeliveries(DeliveryStatusEnum.ON_WAY, DeliveryStatusEnum.DELIVERED);
        processedDeliveryList.forEach(deliveryService::sendDeliveryResponse);
    }
}
