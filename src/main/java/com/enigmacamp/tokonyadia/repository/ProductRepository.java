package com.enigmacamp.tokonyadia.repository;

import com.enigmacamp.tokonyadia.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // findAllByNameLike --> query

    List<Product> findAllByNameLikeIgnoreCase(String name);

    // % LIKE %

}