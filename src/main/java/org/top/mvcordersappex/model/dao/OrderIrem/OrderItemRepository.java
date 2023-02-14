package org.top.mvcordersappex.model.dao.OrderIrem;

import org.springframework.data.repository.CrudRepository;
import org.top.mvcordersappex.model.entity.OrderItem;

import java.util.Optional;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer> {

    Optional<OrderItem> findById(Integer integer);
}
