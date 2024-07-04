package com.enigmacamp.tokonyadia.service;

import com.enigmacamp.tokonyadia.entity.Product;

import java.util.List;


public interface ProductService {
    Product create(Product product);
    List<Product> getAll(String name);
    Product getById(String id);
    Product update(Product product);
    void deleteById(String id);

}
