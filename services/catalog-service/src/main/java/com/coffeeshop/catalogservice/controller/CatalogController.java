package com.coffeeshop.catalogservice.controller;

import com.coffeeshop.catalogservice.dto.CreateProductRequest;
import com.coffeeshop.catalogservice.model.Product;
import com.coffeeshop.catalogservice.repo.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final ProductRepository repo;

    public CatalogController(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/items")
    public List<Product> list() {
        return repo.findAll();
    }

    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody CreateProductRequest req) {
        Product p = new Product();
        p.setName(req.name);
        p.setPrice(req.price); // BigDecimal
        p.setStock(req.stock);
        return repo.save(p);
    }
}