package org.top.mvcordersappex.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "order_item_t")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="item_id",nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    private Order order;

    public OrderItem() {
        id = -1;
        quantity = 0;
        item = null;
        order = null;
    }

    public OrderItem(Integer id, Integer quantity, Item item, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.item = item;
        this.order = order;
    }
    public OrderItem(Integer quantity, Item item, Order order) {
        this.quantity = quantity;
        this.item = item;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @JsonIgnore
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return id + " - " + quantity + " - " + item + " - " + order;
    }
}
