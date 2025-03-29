package com.brian.productservice.dtos.product;


import com.brian.productservice.models.Category;
import com.brian.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductReqResDto {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private String categoryName;



    public static Product ToProduct(CreateProductReqResDto dto) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setImageUrl(dto.getImageUrl());
        Category category = new Category();
        category.setName(dto.getCategoryName());
        product.setCategory(category);
        product.setId(dto.getId());

        return product;
    }
}
