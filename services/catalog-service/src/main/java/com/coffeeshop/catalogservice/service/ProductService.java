package com.coffeeshop.catalogservice.service;

import com.coffeeshop.catalogservice.dto.CreateProductRequest;
import com.coffeeshop.catalogservice.model.Product;
import com.coffeeshop.catalogservice.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product create(CreateProductRequest req) {
        Product p = new Product();
        p.setName(req.getName());
        p.setPrice(req.getPrice());
        p.setStock(req.getStock() == null ? 0 : req.getStock());
        return repo.save(p);
    }

    public List<Product> findAll() {
        return repo.findAll();
    }
}