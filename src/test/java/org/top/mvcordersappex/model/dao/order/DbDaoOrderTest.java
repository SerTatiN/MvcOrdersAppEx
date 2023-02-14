package org.top.mvcordersappex.model.dao.order;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.GsonTester;
import org.top.mvcordersappex.model.dao.client.DbDaoClient;
import org.top.mvcordersappex.model.entity.Client;
import org.top.mvcordersappex.model.entity.Item;
import org.top.mvcordersappex.model.entity.Order;
import org.top.mvcordersappex.model.entity.OrderItem;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DbDaoOrderTest {
    @Autowired
    private DbDaoOrder dbDaoOrder;
    @Autowired
    private DbDaoClient dbDaoClient;

    @Test
    void listAll() {
        List<Order> orders = dbDaoOrder.listAll();
        for (Order order : orders) {
            System.out.println(order.getId() + " - " + order.getDescription());
//            System.out.println(order.getId()+" - " + order.getDescription() + " - " + order.getClient() + " - "
//                + order.getOrderItem());
        }
    }

    @Test
    void getById() {
        List<Order> orders = dbDaoOrder.listAll();
        int id = 1;
        System.out.println("id=" + id + " : " + orders.get(id-1).getId() + " - " + orders.get(id-1).getDescription());

        Optional<Order> orderId = dbDaoOrder.getById(id);
        if (orderId.isPresent()) {
            System.out.println("id = "+id+ ":" + orderId.get().getId() + " / " + orderId.get().getDescription());
            assertEquals(orderId.get().getId(),id, "not");
        }
        id = orders.size() +1;
        orderId = dbDaoOrder.getById(id);
        System.out.println("id = "+id+ " :" + orderId);
        assertEquals(orderId, Optional.empty(), "not null");

    }

    @Test
    void save() {
        String desc = "заказ3";

       Optional<Client> client = dbDaoClient.getById(2);
//        Set<OrderItem> orderItems = new HashSet<>();
//        OrderItem orderItem = new OrderItem(2, item,)
//        orderItems.add();


        Order orderNew = new Order(desc, client.get());

        Order orderSave = dbDaoOrder.save(orderNew);
        System.out.println(orderSave.getDescription() + " - " + desc);

        assertEquals(orderSave.getDescription(), desc);

    }

    @Test
    void update() {
        int id = 3;
        String desc = "order3";
        Optional<Client> client = dbDaoClient.getById(2);

        Order orderFoUp = new Order(id, desc, client.get());
        Order orderUp = dbDaoOrder.update(orderFoUp);

        System.out.println(orderUp.getDescription() + " - "  + desc);
        assertEquals(orderUp.getDescription(), desc);
        assertEquals(orderUp.getId(), id);
    }

    @Test
    void delete() {
        int id = 5;
        dbDaoOrder.delete(id);
        Optional<Order> orderDel = dbDaoOrder.getById(id);
        assertEquals(orderDel,Optional.empty(), "not null");
    }
}