package com.brian.productservice.services;

import com.brian.productservice.dtos.fakestore.FakeStoreReqResDTO;
import com.brian.productservice.models.Product;
import org.springframework.stereotype.Service;

public interface ProductService {
     FakeStoreReqResDTO CreateProduct(Product product);
}
