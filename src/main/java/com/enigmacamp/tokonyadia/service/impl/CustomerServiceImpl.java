package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.dto.request.CustomerRequest;
import com.enigmacamp.tokonyadia.dto.response.CustomerResponse;
import com.enigmacamp.tokonyadia.entity.Customer;
import com.enigmacamp.tokonyadia.repository.CustomerRepository;
import com.enigmacamp.tokonyadia.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;


    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        // Create entitas aru dari customer request
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setAddress(request.getAddress());
        customer.setPhone(request.getPhone());
        customer.setBirthDate(request.getBirthDate());

        // save customer
        customer = customerRepository.saveAndFlush(customer);

        CustomerResponse response = new CustomerResponse();
        response.setName(customer.getName());
        response.setPhone(customer.getPhone());
        response.setAddress(customer.getAddress());
        return response;
    }

    @Override
    public List<Customer> getAll(String name) {
        if (name != null) {
            return customerRepository.findAllByNameLikeIgnoreCase("%" + name + "%");
        }
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(String id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElseThrow(null);
    }

    @Override
    public Customer update(String id, CustomerRequest customer) {
        return null;
    }

//    @Override
//    public Customer update(String id, CustomerRequest customer) {
//        if (!customerRepository.existsById(customer.getId())) {
//            throw new IllegalArgumentException("Customer ID "+ customer.getId() + " not found");
//        }
//        return customerRepository.saveAndFlush(customer);
//    }

    @Override
    public void deleteById(String id) {
        customerRepository.deleteById(id);
    }


}
