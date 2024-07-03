package com.enigmacamp.tokonyadia.service;

import com.enigmacamp.tokonyadia.entity.Product;

import java.util.List;


public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProduct();
    Product updateProduct(Product product);
    Product deleteProduct(Product product);

}
