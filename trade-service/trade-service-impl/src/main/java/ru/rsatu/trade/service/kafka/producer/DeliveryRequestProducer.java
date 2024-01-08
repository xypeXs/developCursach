package ru.rsatu.trade.service.kafka.producer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import ru.rsatu.trade.entity.Delivery;
import ru.rsatu.trade.mapper.DeliveryMapper;
import ru.rsatu.model.kafka.DeliveryRequestRecord;
import ru.rsatu.model.kafka.KafkaConstant;

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
