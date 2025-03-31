package com.brian.productservice.controller;

import com.brian.productservice.dtos.fakestore.FakeStoreReqResDTO;
import com.brian.productservice.dtos.product.CreateProductReqResDto;
import com.brian.productservice.models.Product;
import com.brian.productservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<FakeStoreReqResDTO> getProducts() {
        List<FakeStoreReqResDTO> reqResDTO = productService.getAllProducts();
        return reqResDTO;
    }
    @GetMapping("/id/{id}")
    public FakeStoreReqResDTO getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }
    @GetMapping("/name/{name}")
    public FakeStoreReqResDTO getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }
    @PostMapping
    public FakeStoreReqResDTO createProduct(@RequestBody CreateProductReqResDto createProductReqResDto) {

        Product product = CreateProductReqResDto.ToProduct(createProductReqResDto);

        FakeStoreReqResDTO response = productService.CreateProduct(product);


        return response;



    };

    @PatchMapping("/id/{id}")
    public FakeStoreReqResDTO updateProductById(@PathVariable Long id,@RequestBody CreateProductReqResDto createProductReqResDto) {
        Product product = CreateProductReqResDto.ToProduct(createProductReqResDto);
        product.setId(id);

        return productService.updateProductById(id, product);

    }

    @DeleteMapping("/id/{id}")
    public String deleteProduct(@PathVariable Long id) {

        return productService.deleteProductById(id);
    };



}
