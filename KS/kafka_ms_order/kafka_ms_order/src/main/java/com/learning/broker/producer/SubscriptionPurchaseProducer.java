package com.learning.broker.producer;

import com.learning.broker.message.SubscriptionPurchaseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionPurchaseProducer {

    @Autowired
    private KafkaTemplate<String, SubscriptionPurchaseMessage> kafkaTemplate;

    public void publish(SubscriptionPurchaseMessage message){
        kafkaTemplate.send("t-commodity-subscription-purchase", message.getUsername(), message);
    }

}
