package org.top.mvcordersappex.model.dao.order;

import org.springframework.data.repository.CrudRepository;
import org.top.mvcordersappex.model.entity.Order;

import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Integer> {

    Optional<Order> findById(Integer integer);
}
