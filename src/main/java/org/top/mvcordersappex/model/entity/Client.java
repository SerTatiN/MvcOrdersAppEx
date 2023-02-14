package org.top.mvcordersappex.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="client_t")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String clientName;


    @OneToMany(mappedBy="client", cascade = CascadeType.ALL) //с PERSIST доработать метод delete (проверку на наличте заказов)
    private Set<Order> orders=null;


    public Client(Integer id, String clientName, Set<Order> orders) {
        this.id = id;
        this.clientName = clientName;
        this.orders = orders;
    }

    public Client() {
        id = -1;
        clientName = "";
        orders =  new HashSet<>();
    }

    public Client(String clientName) {
        this.clientName = clientName;
    }

    public Client(Integer id, String clientName) {
        this.id = id;
        this.clientName = clientName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String name) {
        this.clientName = name;
    }

    public Set<Order> getOrders() {
//        System.out.println("getOrders()");
//        for(Order or : orders){
//               System.out.println(or.getId());
//           }
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return id + " - " + clientName;
    }
}