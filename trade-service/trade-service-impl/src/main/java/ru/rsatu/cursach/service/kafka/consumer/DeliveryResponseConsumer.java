package ru.rsatu.cursach.service.kafka.consumer;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.mapper.DeliveryMapper;
import ru.rsatu.cursach.model.kafka.DeliveryResponseRecord;
import ru.rsatu.cursach.model.kafka.KafkaConstant;
import ru.rsatu.cursach.service.DeliveryService;

@ApplicationScoped
public class DeliveryResponseConsumer {

    @Inject
    DeliveryService deliveryService;

    @Inject
    DeliveryMapper deliveryMapper;

    @Blocking
    @Incoming(KafkaConstant.Topic.DELIVERY_RESPONSE)
    public void receiveDeliveryResponse(DeliveryResponseRecord responseRecord) {
        Delivery delivery = deliveryMapper.mapToEntity(responseRecord);
        deliveryService.processDeliveryResponse(delivery);
    }
}
