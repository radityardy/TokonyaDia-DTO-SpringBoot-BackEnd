package com.enigmacamp.tokonyadia.service.impl;

import com.enigmacamp.tokonyadia.entity.Product;
import com.enigmacamp.tokonyadia.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    List<Product> dbProducts = new ArrayList<Product>();

    @Override
    public Product saveProduct(Product product) {

        // save product on list memory
        dbProducts.add(product);

        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        return dbProducts;
    }

    @Override
    public Product updateProduct(Product product) {
        for (int i = 0; i < dbProducts.size(); i++) {
            if (dbProducts.get(i).getId() == product.getId()) {
                dbProducts.set(i, product);
                break;
            }
        }
        return product;
    }

    @Override
    public Product deleteProduct(Product product) {
        dbProducts.removeIf(p -> p.getId() == product.getId());
        return product;
    }
}
