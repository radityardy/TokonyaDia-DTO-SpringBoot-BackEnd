package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.model.dto.request.ProductRequest;
import com.enigmacamp.tokonyadia.model.dto.response.CustomerResponse;
import com.enigmacamp.tokonyadia.model.dto.response.ProductResponse;
import com.enigmacamp.tokonyadia.model.entity.Customer;
import com.enigmacamp.tokonyadia.model.entity.Product;
import com.enigmacamp.tokonyadia.repository.ProductRepository;
import com.enigmacamp.tokonyadia.service.ProductService;
import com.enigmacamp.tokonyadia.utils.exeptions.ResourceNotFoundExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse create(ProductRequest request) {
        Product product  = Product.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();

        return convertToProductResponse(productRepository.saveAndFlush(product));
    }

    @Override
    public List<ProductResponse> getAll(String name) {
        if (name != null) {
            return productRepository.findAllByNameLikeOrderByNameAsc("%" + name + "%").stream().map(this::convertToProductResponse).toList();
        }
        return productRepository.findAll().stream().map(this::convertToProductResponse).toList();
    }

    @Override
    public ProductResponse getById(String id) {
        return convertToProductResponse(findByidOrThrowNotFound(id));
    }

    @Override
    public ProductResponse updatePut(ProductRequest request) {
        findByidOrThrowNotFound(request.getId());

        Product product = Product.builder()
                .id(request.getId())
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();

        return convertToProductResponse(productRepository.saveAndFlush(product));
    }

    @Override
    public ProductResponse updatePatch(ProductRequest request) {
        findByidOrThrowNotFound(request.getId());

        Product existingProduct = getProductById(request.getId());

        if (request.getName() != null) existingProduct.setName(request.getName());
        if (request.getStock() != null) existingProduct.setStock(request.getStock());
        if (request.getPrice() != null) existingProduct.setPrice(request.getPrice());

        return convertToProductResponse(productRepository.saveAndFlush(existingProduct));
    }

    @Override
    public void deleteById(String id) {
        Product product = findByidOrThrowNotFound(id);
        productRepository.delete(product);
    }

    @Override
    public Product getProductById(String id) {
        return findByidOrThrowNotFound(id);
    }

    private Product findByidOrThrowNotFound(String id){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundExeption("Product not found"));

        return product;
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
