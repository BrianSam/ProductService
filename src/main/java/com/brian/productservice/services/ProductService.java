package com.brian.productservice.services;

import com.brian.productservice.dtos.fakestore.FakeStoreReqResDTO;
import com.brian.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
     FakeStoreReqResDTO CreateProduct(Product product);

     List<FakeStoreReqResDTO> getAllProducts();

     FakeStoreReqResDTO getProductById(Long id);
     FakeStoreReqResDTO getProductByName(String name);

     FakeStoreReqResDTO updateProductById(Long id,Product product );

     String deleteProductById(Long id);

}
