package com.lambdaschool.orders.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ordnum;
    private double ordamount;
    private double advanceamount;

    @ManyToOne
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties(value = "orders")
    private Customer customer;

    private String orderdescription;


    @ManyToMany()
    @JoinTable(name = "orderspayments",
    joinColumns = @JoinColumn(name = "ordnum"),
    inverseJoinColumns = @JoinColumn(name = "paymentid"))
    @JsonIgnoreProperties(value = "orders")
    private Set<Payment> payments = new HashSet<>();


    public Order(
        double ordamount,
        double advanceamount,
        String orderdescription)
    {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.orderdescription = orderdescription;
    }

    public Order()
    {
    }

    public long getOrdnum()
    {
        return ordnum;
    }

    public void setOrdnum(long ordnum)
    {
        this.ordnum = ordnum;
    }

    public double getOrdamount()
    {
        return ordamount;
    }

    public void setOrdamount(double ordamount)
    {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount()
    {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount)
    {
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription()
    {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription)
    {
        this.orderdescription = orderdescription;
    }
}
