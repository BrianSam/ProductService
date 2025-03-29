package com.brian.productservice.models;


import java.util.List;


public class Category extends BaseModel {
    private String name;
    private String description;
    private List<Product> featuredProducts;
    private List<Product> allProducts;
    private int countOfProducts;

}


