package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.entity.Customer;
import com.enigmacamp.tokonyadia.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    List<Customer> dbCustomers = new ArrayList<Customer>();

    @Override
    public Customer saveCustomer(Customer customer) {
        dbCustomers.add(customer);
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return dbCustomers;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        for (int i = 0; i < dbCustomers.size(); i++) {
            if (dbCustomers.get(i).getId().equals(customer.getId())) {
                dbCustomers.set(i, customer);
                break;
            }
        }
        return customer;
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        dbCustomers.removeIf(c -> c.getId().equals(customer.getId()));
        return customer;
    }
}
