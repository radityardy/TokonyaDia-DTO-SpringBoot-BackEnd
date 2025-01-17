package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.model.dto.request.CustomerRequest;
import com.enigmacamp.tokonyadia.model.dto.response.CustomerResponse;
import com.enigmacamp.tokonyadia.model.entity.Customer;
import com.enigmacamp.tokonyadia.repository.CustomerRepository;
import com.enigmacamp.tokonyadia.service.CustomerService;
import com.enigmacamp.tokonyadia.utils.exeptions.ResourceNotFoundExeption;
import com.enigmacamp.tokonyadia.utils.specifications.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerResponse createCustomer(CustomerRequest request) {
        // Create entitas baru daru customerRequest
        Customer customer =  new Customer();
        customer.setName(request.getName());
        customer.setPhoneNumber(request.getPhoneNumber());
        customer.setAddress(request.getAddress());
        customer.setBirthDate(request.getBirthDate());
        customer.setUser(request.getUser());

        // Save customer
        customer = customerRepository.saveAndFlush(customer);
        return convertToCustomerResponse(customer);
    }

    @Override
    public CustomerResponse updateCustomer(CustomerRequest request) {
        findByidOrThrowNotFound(request.getId());
        Customer customer = customerRepository.saveAndFlush(
                Customer.builder()
                        .id(request.getId())
                        .name(request.getName())
                        .phoneNumber(request.getPhoneNumber())
                        .birthDate(request.getBirthDate())
                        .address(request.getAddress()).build()
        );
        return convertToCustomerResponse(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        Customer customer = findByidOrThrowNotFound(id);
        customerRepository.delete(customer);
    }


    @Override
    public CustomerResponse getCustomerById(String id) {
        Customer customer = findByidOrThrowNotFound(id);
        return convertToCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> getAllCustomer() {
        return customerRepository.findAll().stream().map(this::convertToCustomerResponse).toList();
    }

    @Override
    public Customer getById(String id) {
        return findByidOrThrowNotFound(id);
    }

    @Override
    public Page<CustomerResponse> getCustomerPerPage(Pageable pageable, CustomerRequest customerRequest) {

        Specification<Customer> specification = CustomerSpecification.getSpecification(customerRequest);
        Page<Customer> customerList = customerRepository.findAll(specification, pageable);

        return customerList.map(this::convertToCustomerResponse);
    }

    private Customer findByidOrThrowNotFound(String id){
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Customer not found"));
    }

    private CustomerResponse convertToCustomerResponse(Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .phoneNumber(customer.getPhoneNumber())
                .birthDate(customer.getBirthDate())
                .address(customer.getAddress())
                .build();
    }
}

