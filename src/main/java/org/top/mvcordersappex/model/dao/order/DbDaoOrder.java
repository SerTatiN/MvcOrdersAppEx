package org.top.mvcordersappex.model.dao.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.mvcordersappex.model.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DbDaoOrder implements IDaoOrder{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> listAll() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    public Optional<Order> getById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        if (orderRepository.findById(order.getId()).isPresent()) {
            return orderRepository.save(order);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (orderRepository.findById(id).isPresent()) {
            Order order = orderRepository.findById(id).get();
            orderRepository.deleteById(id);
        }

    }
}
