package org.top.mvcordersappex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.mvcordersappex.model.dao.OrderIrem.IDaoOrderItem;

import org.top.mvcordersappex.model.dao.item.IDaoItem;
import org.top.mvcordersappex.model.dao.order.IDaoOrder;

import org.top.mvcordersappex.model.entity.Item;
import org.top.mvcordersappex.model.entity.Order;
import org.top.mvcordersappex.model.entity.OrderItem;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order2")
public class OrderItemController {
    @Autowired
    public IDaoOrderItem daoOrderItem;
    @Autowired
    public IDaoOrder daoOrder;

    @Autowired
    public IDaoItem daoItem;

    @GetMapping("/")
    public String getAll(Model model){
        List<OrderItem> orderItems = daoOrderItem.listAll();
        model.addAttribute("orderItems", orderItems);
        return "order2/orderIt-list";
    }

    @GetMapping("/add/")
    public String getOrderItemForm(Model model){
        OrderItem orderItem = new OrderItem();
        List<Order> orders = daoOrder.listAll();
        List<Item> items = daoItem.listAll();
        model.addAttribute("orderItem", orderItem);
        model.addAttribute("orders", orders); // для вставки в <optional>
        model.addAttribute("items",items); // для вставки в <optional>
        return "order2/orderIt-form";
    }

    @PostMapping("/add/")
    public String addNewForm(OrderItem orderItem, RedirectAttributes ra){
        OrderItem orderItemAdd = daoOrderItem.save(orderItem);
        ra.addFlashAttribute("goodMsg", "OrderItem " + orderItemAdd.getId() + " added");

        return "redirect:/order2/";
    }
    // обработчик (Update) для возврата формы  обновления заказ-товара
    @GetMapping("/update/{id}")
    public String getOrderItemUpdateForm(@PathVariable("id") Integer orderItId, Model model){
        Optional<OrderItem> orderItemUpd = daoOrderItem.getById(orderItId);
        if (orderItemUpd.isPresent()) {
            List<Order> orders= daoOrder.listAll();
            List<Item> items = daoItem.listAll();
            model.addAttribute("orderItem", orderItemUpd.get());
            model.addAttribute("orders", orders); // для вставки в <optional>
            model.addAttribute("items",items); // для вставки в <optional>
        }
        return "order2/orderIt-update";
    }

    // обработчик (Update) обновления заказ-товара
    @PostMapping("/update/")
    public String updateOrderItem(OrderItem orderItem) {
        // 1. сохранить заказ
        daoOrderItem.update(orderItem);
        // 2. вернуться на список сущностей заказа
        return "redirect:/order2/";
    }
    @GetMapping("/detail/{id}")
    public String orderItemDetail(@PathVariable("id") Integer ordItId, Model model){
        Optional<OrderItem> orderItem = daoOrderItem.getById(ordItId);
        if (orderItem.isPresent()) {
            model.addAttribute("orderItem", orderItem.get());
        }
        return  "order2/orderIt-detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderItem(@PathVariable ("id") Integer orderItId){
        daoOrderItem.delete(orderItId);
        return "redirect:/order2/";
    }


}
