package com.brian.productservice.services;

import com.brian.productservice.dtos.fakestore.FakeStoreReqResDTO;
import com.brian.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceFakeStoreImpl implements ProductService {

    private RestTemplate restTemplate;

    private ProductServiceFakeStoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public FakeStoreReqResDTO CreateProduct(Product product) {
        FakeStoreReqResDTO request = FakeStoreReqResDTO.fromProductToFakeStoreReqResDTO(product);
        FakeStoreReqResDTO response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreReqResDTO.class
        );

        return response;

    }

    @Override
    public List<FakeStoreReqResDTO> getAllProducts() {
        return List.of();
    }

    @Override
    public FakeStoreReqResDTO getProductById(Long id) {
        return null;
    }

    @Override
    public FakeStoreReqResDTO getProductByName(String name) {
        return null;
    }

    @Override
    public FakeStoreReqResDTO updateProductById(Long id, Product product) {
        return null;
    }

    @Override
    public String deleteProductById(Long id) {
        return null;
    }
}
