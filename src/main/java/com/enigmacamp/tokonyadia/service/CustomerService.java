package com.enigmacamp.tokonyadia.service;

import com.enigmacamp.tokonyadia.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer create(Customer customer);
    List<Customer> getAll(String name);
    Customer getById(String id);
    Customer update(Customer customer);
    void deleteById(String id);
}
