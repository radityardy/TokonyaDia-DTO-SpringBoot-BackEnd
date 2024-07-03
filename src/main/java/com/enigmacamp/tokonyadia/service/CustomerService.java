package com.enigmacamp.tokonyadia.service;

import com.enigmacamp.tokonyadia.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Customer customer);
}
