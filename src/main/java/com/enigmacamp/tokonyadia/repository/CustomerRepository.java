package com.enigmacamp.tokonyadia.repository;

import com.enigmacamp.tokonyadia.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findAllByNameLikeIgnoreCase(String name);

}
