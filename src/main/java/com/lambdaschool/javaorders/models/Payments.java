package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentid;
    @Column(nullable = false, unique = true)
    private String type;
    @ManyToMany(mappedBy = "payments")
    private Set<Orders> orders = new HashSet<>();

    public Payments(String type) {
        this.type = type;
    }

    public Long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Long paymentid) {
        this.paymentid = paymentid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
