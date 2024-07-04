package com.enigmacamp.tokonyadia.controller;

import com.enigmacamp.tokonyadia.constant.APIUrl;
import com.enigmacamp.tokonyadia.entity.Product;
import com.enigmacamp.tokonyadia.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.PRODUCT_API)
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product createNewProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    // /api/product?name = maka semua nama akan muncul namun jika di inputkan angka maka akan keluar sesuai namanya
    @GetMapping
    public List<Product> getAllProduct(
            @RequestParam(name = "name", required = false) String name) {
        return productService.getAll(name);
    }

    @GetMapping("/{id}") // /api/product/{UUID}
    public Product getProductById(@PathVariable String id) {
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable String id, @RequestBody Product product) {
        try {
            product.setId(id);
            Product updatedProduct = productService.update(product);
            return ResponseEntity.ok(updatedProduct);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @DeleteMapping("/{id}")
    public void deleteById(String id) {
        productService.deleteById(id);
    }
}
