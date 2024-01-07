package ru.rsatu.cursach.service.kafka.producer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.mapper.DeliveryMapper;
import ru.rsatu.cursach.model.kafka.DeliveryResponseRecord;
import ru.rsatu.cursach.model.kafka.KafkaConstant;

@ApplicationScoped
public class DeliveryResponseProducer {

    @Inject
    DeliveryMapper deliveryMapper;

    @Inject
    @Channel(KafkaConstant.Topic.DELIVERY_RESPONSE)
    Emitter<DeliveryResponseRecord> deliveryResponseEmitter;

    public void sendDeliveryResponse(Delivery delivery) {
        DeliveryResponseRecord responseRecord = deliveryMapper.mapToRecord(delivery);
        deliveryResponseEmitter.send(responseRecord);
    }
}
