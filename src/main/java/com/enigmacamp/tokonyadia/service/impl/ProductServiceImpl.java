package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.repository.ProductRepository;
import com.enigmacamp.tokonyadia.entity.Product;
import com.enigmacamp.tokonyadia.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public List<Product> getAll(String name) {
        if (name != null) {
            return productRepository.findAllByNameLikeIgnoreCase("%" + name + "%");
        }
        return productRepository.findAll();
    }

    @Override
    public Product getById(String id) {
        // optional -> List/satuan
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(null);
    }


    @Override
    public Product update(Product product) {
//        getById(product.getId());
        if (!productRepository.existsById(product.getId())){
            throw new IllegalArgumentException("Product ID " + product.getId() + " not found");
        }
        return productRepository.saveAndFlush(product);
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
