package com.brian.productservice.services;

import com.brian.productservice.dtos.fakestore.FakeStoreReqResDTO;
import com.brian.productservice.models.Category;
import com.brian.productservice.models.Product;
import com.brian.productservice.repositories.CategoryInterface;
import com.brian.productservice.repositories.ProductInterface;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service()
public class ProductServiceDBImpl implements ProductService {

    ProductInterface productInterface;
    CategoryInterface categoryInterface;

    public ProductServiceDBImpl (ProductInterface productInterface, CategoryInterface categoryInterface) {
        this.productInterface = productInterface;
        this.categoryInterface = categoryInterface;
    }
    @Override
    public FakeStoreReqResDTO CreateProduct(Product product) {

        Optional<Category>findCategory=categoryInterface.findByName(product.getCategory().getName());
        Category category= null;
        if(findCategory.isEmpty()){
            category=categoryInterface.save(product.getCategory());
        }
        else{
            category=findCategory.get();
        }

        product.setCategory(category);


        Product response = productInterface.save(product);
        return FakeStoreReqResDTO.fromProductToFakeStoreReqResDTO(response);
    }

    public List<FakeStoreReqResDTO> getAllProducts() {
        List<FakeStoreReqResDTO> allProducts = new ArrayList<>();

        List<Product> products = productInterface.findAll();
        if(!products.isEmpty()){
            for (Product product : products) {
                allProducts.add(FakeStoreReqResDTO.fromProductToFakeStoreReqResDTO(product));
            }
        }
        else{
            throw new RuntimeException("No products found");
        }

        return allProducts;


    }

    @Override
    public FakeStoreReqResDTO getProductById(Long id) {
       Product product = productInterface.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found for id: " + id));

       return FakeStoreReqResDTO.fromProductToFakeStoreReqResDTO(product);

    }

    @Override
    public FakeStoreReqResDTO getProductByName(String name) {

        Product product = productInterface.findByTitleEquals(name).orElseThrow(() -> new RuntimeException("Product not found "+ name ));
        return FakeStoreReqResDTO.fromProductToFakeStoreReqResDTO(product);
    }

    @Override
    public FakeStoreReqResDTO updateProductById(Long id, Product product) {

        Product productToUpdate = productInterface.findById(id).orElseThrow(() -> new RuntimeException("Product not found "+ id ));
        if (product.getTitle() != null){
            productToUpdate.setTitle(product.getTitle());
        }
        if (product.getDescription() != null){
            productToUpdate.setDescription(product.getDescription());
        }
        if (product.getPrice() != null){
            productToUpdate.setPrice(product.getPrice());
        }
        if (product.getCategory().getName() != null){
            if(categoryInterface.findByName(product.getCategory().getName()).isEmpty()){
                productToUpdate.setCategory(categoryInterface.save(product.getCategory()));
            }
            else{
                productToUpdate.setCategory(categoryInterface.findByName(product.getCategory().getName()).get());
            }

        }
        if(product.getImageUrl() != null){
            productToUpdate.setImageUrl(product.getImageUrl());
        }


        return FakeStoreReqResDTO.fromProductToFakeStoreReqResDTO(productInterface.save(productToUpdate));

    }

    @Override
    @Transactional
    public String deleteProductById(Long id) {
        Optional<Product> productToDelete = productInterface.findById(id);
        if (productToDelete.isPresent()) {
                    productInterface.deleteById(id);
                    return String.format("Product with id: %d was deleted", id);
        }
        else {
            throw new RuntimeException("No product exist with id : " + id);
        }


    }


}
