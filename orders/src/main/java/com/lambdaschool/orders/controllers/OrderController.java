package com.lambdaschool.orders.controllers;


import com.lambdaschool.orders.models.Order;
import com.lambdaschool.orders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class OrderController
{
    @Autowired
    OrderServices orderServices;


    //http://localhost:2019/orders/order/7
    @GetMapping(value = "order/{orderid}", produces = "application/json")
    public ResponseEntity<?> getOrder(@PathVariable long orderid)
    {
        Order order = orderServices.findById();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }


    //http://localhost:2019/orders/advanceamount
    @GetMapping(value = "/advanceamount", produces = "application/json")
    public ResponseEntity<?> getAdvanceamount()
    {
        Order order = orderServices.findAmount();
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
