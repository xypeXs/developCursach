package ru.rsatu.cursach.service.kafka.consumer;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.mapper.DeliveryMapper;
import ru.rsatu.cursach.model.kafka.DeliveryRequestRecord;
import ru.rsatu.cursach.model.kafka.KafkaConstant;
import ru.rsatu.cursach.service.DeliveryService;

@ApplicationScoped
public class DeliveryRequestConsumer {

    @Inject
    DeliveryService deliveryService;

    @Inject
    DeliveryMapper deliveryMapper;

    @Blocking
    @Incoming(KafkaConstant.Topic.DELIVERY_REQUEST)
    public void receiveDeliveryRequest(DeliveryRequestRecord requestRecord) {
        Delivery delivery = deliveryMapper.mapToEntity(requestRecord);
        deliveryService.saveDeliveryRequest(delivery);
        deliveryService.sendDeliveryResponse(delivery);
    }
}
