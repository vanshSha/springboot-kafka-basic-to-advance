package kafka_ms_order.repository;

import kafka_ms_order.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Integer> {

}
