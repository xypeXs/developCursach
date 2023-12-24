package ru.rsatu.cursach.service.kafka.producer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import ru.rsatu.cursach.entity.Delivery;
import ru.rsatu.cursach.mapper.DeliveryMapper;
import ru.rsatu.cursach.model.kafka.DeliveryRequestRecord;
import ru.rsatu.cursach.model.kafka.KafkaConstant;

@ApplicationScoped
public class DeliveryRequestProducer {

    @Inject
    DeliveryMapper deliveryMapper;

    @Inject
    @Channel(KafkaConstant.Topic.DELIVERY_REQUEST)
    Emitter<DeliveryRequestRecord> deliveryRequestEmitter;

    public void sendDeliveryRequest(Delivery delivery) {
        DeliveryRequestRecord requestRecord = deliveryMapper.mapToDeliveryRecord(delivery);
        deliveryRequestEmitter.send(requestRecord);
    }
}
