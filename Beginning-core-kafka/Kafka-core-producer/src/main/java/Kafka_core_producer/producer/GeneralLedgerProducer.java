package Kafka_core_producer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class GeneralLedgerProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendGeneralLedgerMessage(String message){
        kafkaTemplate.send("t-general-leder", message);
    }
}
