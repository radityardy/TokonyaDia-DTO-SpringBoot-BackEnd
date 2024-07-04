package com.enigmacamp.tokonyadia.controller;

import com.enigmacamp.tokonyadia.dto.request.CustomerRequest;
import com.enigmacamp.tokonyadia.dto.response.CustomerResponse;
import com.enigmacamp.tokonyadia.entity.Customer;
import com.enigmacamp.tokonyadia.repository.CustomerRepository;
import com.enigmacamp.tokonyadia.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    @PostMapping()
    public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest request) {
        CustomerResponse createdCustomer = customerService.createCustomer(request);
        return ResponseEntity.ok(createdCustomer);
    }

    @GetMapping
    public List<Customer> getAllCustomer(@RequestParam(name = "name", required = false) String name) {
        return customerService.getAll(name);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        return customerService.getById(id);
    }

    @PutMapping("/{id}")
public ResponseEntity<CustomerResponse> updateCustomer(@PathVariable String id, @RequestBody CustomerRequest request) {
    // Assuming you have an update method that takes an id and a CustomerRequest
    Customer updatedCustomer = customerService.update(id, request);

    // Convert updated customer to CustomerResponse
    CustomerResponse response = new CustomerResponse();
    response.setName(updatedCustomer.getName());
    response.setAddress(updatedCustomer.getAddress());
    response.setPhone(updatedCustomer.getPhone());
    // Add other fields as necessary

    return ResponseEntity.ok(response);
}

    @DeleteMapping("/{id}")
    public void deleteById(String id) {
        customerService.deleteById(id);
    }
}
