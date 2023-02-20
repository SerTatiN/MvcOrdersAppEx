package org.top.mvcordersappex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.top.mvcordersappex.model.dao.client.IDaoClient;
import org.top.mvcordersappex.model.dao.order.IDaoOrder;
import org.top.mvcordersappex.model.entity.Client;
import org.top.mvcordersappex.model.entity.Order;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    public IDaoOrder daoOrder;

    @Autowired
    public IDaoClient daoClient;

    @GetMapping("/")
    public String getAll(Model model){
        List<Order> orders = daoOrder.listAll();
        model.addAttribute("orders", orders);
        return "order/order-list";
    }

    @GetMapping("/add/")
    public String getOrderForm(Model model){
        Order order = new Order();
        List<Client> clients = daoClient.listAll();
        model.addAttribute("order", order);
        model.addAttribute("clients",clients); // для вставки в <optional>
        return "order/order-form";
    }

    @PostMapping("/add/")
    public String addNewForm(Order order, RedirectAttributes ra){
        Order addOrder = daoOrder.save(order);
        ra.addFlashAttribute("goodMsg", "Order " + addOrder.getDescription() + " added");

        return "redirect:/order/";
    }
    // обработчик (Update) для возврата формы  заказа
    @GetMapping("/update/{id}")
    public String getOrderUpdateForm(@PathVariable("id") Integer orderId, Model model){
        Optional<Order> order = daoOrder.getById(orderId);
        if (order.isPresent()) {
            List<Client> clients = daoClient.listAll();
            model.addAttribute("order", order.get());
            model.addAttribute("clients",clients); // для вставки в <optional>
        }
        return "order/order-update";
    }

    // обработчик (Update) заказа
    @PostMapping("/update/")
    public String updateOrder(Order order) {
        // 1. сохранить заказ
        daoOrder.update(order);
        // 2. вернуться на список сущностей заказа
        return "redirect:/order/";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable("id") Integer orderId, @RequestParam String back, Model model){
        Optional<Order> order = daoOrder.getById(orderId);
        if (order.isPresent()) {
            model.addAttribute("order", order.get());
            model.addAttribute("back", back);
        }
        return "order/order-detail";
    }


    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable ("id") Integer orderId){
        daoOrder.delete(orderId);
        return "redirect:/order/";
    }


}
