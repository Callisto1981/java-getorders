package com.lambdaschool.orders.services;

import com.lambdaschool.orders.models.Customer;

public interface CustomerServices
{
    Customer findAllOrders();
    Customer findById();
    Customer findByCustName();
}
