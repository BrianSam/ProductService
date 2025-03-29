package com.brian.productservice.services;

import com.brian.productservice.dtos.fakestore.FakeStoreReqResDTO;
import com.brian.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService {
    @Override
    public FakeStoreReqResDTO CreateProduct(Product product) {
        return null;

    }
}
