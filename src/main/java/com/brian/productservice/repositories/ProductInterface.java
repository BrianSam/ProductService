package com.brian.productservice.repositories;

import com.brian.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductInterface extends JpaRepository<Product, Long> {
}
