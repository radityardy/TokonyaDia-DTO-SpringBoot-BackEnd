package com.enigmacamp.tokonyadia.repository;

import com.enigmacamp.tokonyadia.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
    //    @Query(value = "SELECT * FROM m_customer LIMIT :limit OFFSET :offset", nativeQuery = true)
//    List<Customer> listCustomerPage(@Param("limit") int limit, @Param("offset") int offset);
    @Query("SELECT c FROM Customer c WHERE c.isDeleted = false")
    List<Customer> findAllActiveCustomers();

    @Query("SELECT c FROM Customer c WHERE c.id = :id AND c.isDeleted = false")
    Optional<Customer> findByIdAndNotDeleted(String id);
}
