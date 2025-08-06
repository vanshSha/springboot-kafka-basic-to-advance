package com.learning.broker.stream.inventory;

import com.learning.broker.message.InventoryMessage;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

//@Component
public class InventoryOneStream {

    @Autowired
    void processInventoryStream(StreamsBuilder builder){
        var stringSerde = Serdes.String();
        var inventorySerde = new JsonSerde<>(InventoryMessage.class);
        var longSerde = Serdes.Long();

        builder.stream("t-commodity-inventory", Consumed.with(stringSerde, inventorySerde))
                .mapValues(
                        (item, inventory) -> inventory.getQuantity()
                ).groupByKey()
                .aggregate(
                        () -> 0L,
                        (aggKey, newValue, aggValue) -> aggValue + newValue,
                        Materialized.with(stringSerde, longSerde)
                ).toStream().to("t-commodity-inventory-total-one",
                        Produced.with(stringSerde, longSerde));
    }
}
