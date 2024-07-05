package com.enigmacamp.tokonyadia.controller;


import com.enigmacamp.tokonyadia.constant.APIUrl;
import com.enigmacamp.tokonyadia.dto.request.ProductRequest;
import com.enigmacamp.tokonyadia.dto.response.ProductResponse;
import com.enigmacamp.tokonyadia.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.PRODUCT_API)
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createNewProduct(@RequestBody ProductRequest request) {
        ProductResponse createProduct = productService.create(request);
        return ResponseEntity.ok(createProduct);
    }


    @PutMapping
    public ResponseEntity<ProductResponse> updateProduct(@Valid @RequestBody ProductRequest request) {
        ProductResponse updateProduct = productService.updateProduct(request);
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok(" Success delete customer with id " + id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getCProductById(@PathVariable String id) {
        ProductResponse productResponse = productService.getById(id);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct(String id) {
        return ResponseEntity.ok(productService.getAllProduct(id));
    }
}