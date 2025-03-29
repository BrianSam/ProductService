package com.brian.productservice.services;

import com.brian.productservice.dtos.fakestore.FakeStoreReqResDTO;
import com.brian.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Primary
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
}
