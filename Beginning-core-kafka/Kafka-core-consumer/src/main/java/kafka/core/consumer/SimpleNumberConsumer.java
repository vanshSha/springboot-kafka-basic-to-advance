package kafka.core.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.core.entity.SimpleNumber;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleNumberConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(SimpleNumberConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "t-simple-number")
    public void consume(String message) throws Exception {
        SimpleNumber simpleNumber = objectMapper.readValue(message, SimpleNumber.class);
        int number = simpleNumber.getNumber();
        if (number % 2 != 0) {
            throw new IllegalArgumentException("Number is odd: " + number);
        }
        LOG.info("Number is even: {}", number);

    }

}
