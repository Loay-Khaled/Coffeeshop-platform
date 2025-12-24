package com.coffeeshop.catalogservice.controller;

import com.coffeeshop.catalogservice.dto.CreateProductRequest;
import com.coffeeshop.catalogservice.model.Product;
import com.coffeeshop.catalogservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final ProductService service;

    public CatalogController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/items")
    public List<Product> list() {
        return service.findAll();
    }

    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody CreateProductRequest req) {
        return service.create(req);
    }
}