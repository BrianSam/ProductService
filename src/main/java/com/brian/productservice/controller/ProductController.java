package com.brian.productservice.controller;

import com.brian.productservice.dtos.fakestore.FakeStoreReqResDTO;
import com.brian.productservice.dtos.product.CreateProductReqResDto;
import com.brian.productservice.models.Product;
import com.brian.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public void getProducts() {};
    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id) {
        return "id=" + id;
    }
    @PostMapping
    public FakeStoreReqResDTO createProduct(@RequestBody CreateProductReqResDto createProductReqResDto) {
        Product product = CreateProductReqResDto.ToProduct(createProductReqResDto);

        FakeStoreReqResDTO response = productService.CreateProduct(product);


        return response;

    };
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {};



}
