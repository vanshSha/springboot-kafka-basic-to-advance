package com.learning.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@Configuration
@EnableKafkaStreams
public class KafkaStreamConfig {

//    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
//    KafkaStreamsConfiguration kafkaStreamsConfiguration() {
//        var props = new HashMap<String, Object>();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-stream-" + System.currentTimeMillis());
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//
//        return new KafkaStreamsConfiguration(props);
//
//    }
} //whatever i write down inside application.properties to kafkaStreamConfig
