package com.enigmacamp.tokonyadia.controller;

import com.enigmacamp.tokonyadia.entity.Customer;
import com.enigmacamp.tokonyadia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    CustomerService customerService;

    @Autowired
    public UserController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer postUser(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping
    public List<Customer> getUser() {
        return customerService.getAllCustomer();
    }

    @PutMapping
    public Customer putUser(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @PatchMapping
    public Customer patchUser(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping
    public Customer deleteUser(@RequestBody Customer customer) {
        return customerService.deleteCustomer(customer);
    }
}
