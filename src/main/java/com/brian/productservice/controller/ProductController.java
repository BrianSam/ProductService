package com.brian.productservice.controller;

import com.brian.productservice.dtos.fakestore.CreateProductRequestDto;
import com.brian.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

@RestController("/products")
public class ProductController {
    @GetMapping
    public void getProducts() {};
    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id) {
        return "id=" + id;
    }
    @PostMapping
    public void createProduct(@RequestBody CreateProductRequestDto createProductRequestDto) {};
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {};



}
