package org.top.mvcordersappex.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_t")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String description;

    @ManyToOne
    @JoinColumn(name= "client_id",nullable = false)
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItem;

    public Order() {
        id = -1;
        description = "";
        client = null;
        orderItem = new HashSet<>();
    }

    public Order(Integer id, String description, Client client) {
        this.id = id;
        this.description = description;
        this.client = client;
    }


    public Order(Integer id, String description, Client client, Set<OrderItem> orderItem) {
        this.id = id;
        this.description = description;
        this.client = client;
        this.orderItem = orderItem;
    }
    public Order(String description, Client client, Set<OrderItem> orderItem) {
        this.description = description;
        this.client = client;
        this.orderItem = orderItem;
    }

    public Order(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Order(String description, Client client) {
        this.description = description;
        this.client = client;
    }

    public Order(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   // @JsonIgnore
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Set<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    @Override
    public String toString() {
        return id+" - " + description + " - " + client;
    }
}
