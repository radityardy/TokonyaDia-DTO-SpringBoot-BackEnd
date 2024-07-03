package com.enigmacamp.tokonyadia.controller;

import com.enigmacamp.tokonyadia.entity.Product;
import com.enigmacamp.tokonyadia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product postProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getProduct() {
        return productService.getAllProduct();
    }
    @PutMapping
    public Product putProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @PatchMapping
    public Product patchProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping
    public Product deleteProduct(@RequestBody Product product) {
        return productService.deleteProduct(product);
    }


}
