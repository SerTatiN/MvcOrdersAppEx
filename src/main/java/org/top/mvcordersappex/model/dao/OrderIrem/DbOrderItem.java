package org.top.mvcordersappex.model.dao.OrderIrem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.top.mvcordersappex.model.entity.OrderItem;

import java.util.List;
import java.util.Optional;

@Service
public class DbOrderItem implements IDaoOrderItem{
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItem> listAll() {
        return (List<OrderItem>) orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> getById(Integer id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem update(OrderItem orderItem) {
        if (orderItemRepository.findById(orderItem.getId()).isPresent()) {
            return orderItemRepository.save(orderItem);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (orderItemRepository.findById(id).isPresent()) {
            OrderItem orderItem = orderItemRepository.findById(id).get();
        }
    }
}
