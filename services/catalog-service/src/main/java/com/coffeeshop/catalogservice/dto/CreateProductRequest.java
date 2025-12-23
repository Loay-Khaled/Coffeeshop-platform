package com.coffeeshop.catalogservice.dto;

import java.math.BigDecimal;

public class CreateProductRequest {
    public String name;
    public BigDecimal price;
    public int stock;
}