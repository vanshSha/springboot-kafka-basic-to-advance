package kafka.core.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpoint;
import org.springframework.kafka.config.KafkaListenerEndpointRegistrar;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class GeneralLedgerScheduler {

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    private static final Logger LOG = LoggerFactory.getLogger(GeneralLedgerScheduler.class);

    @Scheduled(cron = "0 54 6 * * *")
    public void pause(){
        LOG.info("Pause listener");
        registry.getListenerContainer("cousumer-ledger-one").pause();
    }

    @Scheduled(cron = "1 56 6 * * *")
    public void resume(){
        LOG.info("Resume listener");
        registry.getListenerContainer("consumer-ledger-one").resume();

    }
}
