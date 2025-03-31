package com.brian.productservice.dtos.product;


import com.brian.productservice.models.Category;
import com.brian.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductReqResDto {

    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;



    public static Product ToProduct(CreateProductReqResDto dto) {
        Product product = new Product();
        if (dto.getTitle() != null) {product.setTitle(dto.getTitle());}
        if (dto.getDescription() != null) {product.setDescription(dto.getDescription());}
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImageUrl());
        Category category = new Category();
        category.setName(dto.getCategoryName());
        product.setCategory(category);

        return product;
    }
}
