package com.lambdaschool.javaorders.models;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ordnum;
    private double ordamount;
    private double advanceamount;
    private String orderdescription;
    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    Customers custcode;
    @ManyToMany()
    @JoinTable(name = "OrdersPayments",
    joinColumns = @JoinColumn(name = "ordnum"),
    inverseJoinColumns = @JoinColumn(name = "paymentid"))
    private Set<Payments> payments = new HashSet<>();
    public Long getOrdnum() {
        return ordnum;
    }

    public Orders(Long ordnum, double ordamount, double advanceamount, String orderdescription, Customers custcode) {
        this.ordnum = ordnum;
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orderdescription = orderdescription;
        this.custcode = custcode;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }
}
