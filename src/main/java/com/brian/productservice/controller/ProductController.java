package com.brian.productservice.controller;

import com.brian.productservice.dtos.fakestore.FakeStoreReqResDTO;
import com.brian.productservice.dtos.product.CreateProductReqResDto;
import com.brian.productservice.models.Product;
import com.brian.productservice.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController()
@RequestMapping("/products")
public class ProductController {


    private RedisTemplate<String,Object> template;
    @Autowired
    private ObjectMapper objectMapper;

    private ProductService productService;
    public ProductController(ProductService productService,RedisTemplate<String,Object> template) {
        this.template = template;
        this.productService = productService;
    }
    @GetMapping
    public List<FakeStoreReqResDTO> getProducts() throws JsonProcessingException {

        String json = null;
        List<FakeStoreReqResDTO> ifHashed = null;
        if (template.opsForHash().get("products","get_hash") != null) {
            json = (String) template.opsForHash().get("products","get_hash");
            ifHashed =   objectMapper.readValue(json, new TypeReference<List<FakeStoreReqResDTO>>() {
            });
        }

        if(ifHashed != null) {
            return ifHashed;
        }

        List<FakeStoreReqResDTO> reqResDTO = productService.getAllProducts();
        String outputJson = objectMapper.writeValueAsString(reqResDTO);
        template.opsForHash().put("products","get_hash", outputJson);
        template.expire("products", Duration.ofMinutes(10));

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
