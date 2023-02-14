package org.top.mvcordersappex.model.entity;

import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table (name ="item_t")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String itemName;

    @Column(nullable = false)
    private Long itemArticle;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    public Item() {
    }

    public Item(Integer id, String itemName, Long itemArticle, Set<OrderItem> orderItems) {
        this.id = id;
        this.itemName = itemName;
        this.itemArticle = itemArticle;
        this.orderItems = orderItems;
    }

    public Item(String itemName, Long itemArticle) {
        this.itemName = itemName;
        this.itemArticle = itemArticle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getItemArticle() {
        return itemArticle;
    }

    public void setItemArticle(Long itemArticle) {
        this.itemArticle = itemArticle;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return id + " - " + itemName + " - " + itemArticle;// - " + orderItems;
    }
}
