package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.dto.request.ProductRequest;
import com.enigmacamp.tokonyadia.dto.response.ProductResponse;
import com.enigmacamp.tokonyadia.entity.Product;
import com.enigmacamp.tokonyadia.repository.ProductRepository;
import com.enigmacamp.tokonyadia.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    //    List<Product> dbProduct = new ArrayList<Product>();
    private final ProductRepository productRepository;

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());


        product = productRepository.saveAndFlush(product);
        return convertToProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProduct(String name) {
        return productRepository.findAll().stream().map(this::convertToProductResponse).toList();
    }

    @Override
    public Product getProductById(String id) {
        return findByIdOrThrowNotFound(id);
    }

    @Override
    public ProductResponse getById(String id) {
        Product product = findByIdOrThrowNotFound(id);
        return convertToProductResponse(product);
    }

    @Override
    public ProductResponse updateProduct(ProductRequest request) {
        findByIdOrThrowNotFound(request.getId());
        Product product = productRepository.saveAndFlush(
                Product.builder()
                        .id(request.getId())
                        .name(request.getName())
                        .price(request.getPrice())
                        .stock(request.getStock())
                        .build()
        );
        return convertToProductResponse(product);
    }

    @Override
    public void deleteProductById(String id) {
        Product product = findByIdOrThrowNotFound(id);
        productRepository.delete(product);

    }

    private Product findByIdOrThrowNotFound(String id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, " Data not found "));
    }


    private ProductResponse convertToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
