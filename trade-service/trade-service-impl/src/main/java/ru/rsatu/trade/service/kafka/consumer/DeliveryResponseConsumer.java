package ru.rsatu.trade.service.kafka.consumer;

import io.smallrye.common.annotation.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import ru.rsatu.trade.entity.Delivery;
import ru.rsatu.trade.mapper.DeliveryMapper;
import ru.rsatu.model.kafka.DeliveryResponseRecord;
import ru.rsatu.model.kafka.KafkaConstant;
import ru.rsatu.trade.service.DeliveryService;

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
