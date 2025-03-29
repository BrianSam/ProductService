package com.brian.productservice.dtos.fakestore;

import com.brian.productservice.models.Category;
import com.brian.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreReqResDTO {



    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;




    public static FakeStoreReqResDTO fromProductToFakeStoreReqResDTO(Product product) {
        FakeStoreReqResDTO fakeStoreReqResDTO = new FakeStoreReqResDTO();
        fakeStoreReqResDTO.setId(product.getId());
        fakeStoreReqResDTO.setTitle(product.getTitle());
        fakeStoreReqResDTO.setDescription(product.getDescription());
        fakeStoreReqResDTO.setPrice(product.getPrice());
        fakeStoreReqResDTO.setImageUrl(product.getImageUrl());
        Category category = new Category();
        category.setName(product.getCategory().getName());
        fakeStoreReqResDTO.setCategoryName(category.getName());
        return fakeStoreReqResDTO;
    }
}
