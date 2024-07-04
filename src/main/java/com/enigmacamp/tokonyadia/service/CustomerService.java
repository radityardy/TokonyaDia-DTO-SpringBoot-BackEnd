package com.enigmacamp.tokonyadia.service;

import com.enigmacamp.tokonyadia.dto.request.CustomerRequest;
import com.enigmacamp.tokonyadia.dto.response.CustomerResponse;
import com.enigmacamp.tokonyadia.entity.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest request);
    List<Customer> getAll(String name);
    Customer getById(String id);
    Customer update(String id, CustomerRequest customer);
    void deleteById(String id);
}
