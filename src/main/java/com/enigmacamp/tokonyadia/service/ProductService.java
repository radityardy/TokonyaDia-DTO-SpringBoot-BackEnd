package com.enigmacamp.tokonyadia.service;

import com.enigmacamp.tokonyadia.model.dto.request.ProductRequest;
import com.enigmacamp.tokonyadia.model.dto.response.ProductResponse;
import com.enigmacamp.tokonyadia.model.entity.Product;

import java.util.List;


public interface ProductService {
    ProductResponse create(ProductRequest request);
    ProductResponse updateProduct(ProductRequest request);
    ProductResponse updatePatch(ProductRequest request);
    void deleteProductById(String id);
    ProductResponse getById(String id);
    List<ProductResponse> getAllProduct(String name);
    Product getProductById(String id);
}
