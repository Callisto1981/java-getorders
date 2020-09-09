package com.lambdaschool.orders.controllers;

import com.lambdaschool.orders.models.Customer;
import com.lambdaschool.orders.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CustomerController
{
    @Autowired
    CustomerServices customerServices;
    //http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> getAllOrders()
    {
        Customer customer = customerServices.findAllOrders();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    //http://localhost:2019/customers/customer/7
    @GetMapping(value = "/customer/{custId}", produces = "application/json")
    public ResponseEntity<?> findCustomerId(@PathVariable long custId)
    {
        Customer customer = customerServices.findById(custId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    //http://localhost:2019/customers/namelike/mes
    @GetMapping(value = "/namelike/{namelike}", produces = "application/json")
    public ResponseEntity<?> getNameLike(@PathVariable String namelike)
    {
        Customer customer = customerServices.findByCustName(namelike);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
