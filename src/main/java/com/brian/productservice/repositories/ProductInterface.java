package com.brian.productservice.repositories;

import com.brian.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductInterface extends JpaRepository<Product, Long> {

    @Override
     Product save(Product product);

    @Override
    List<Product> findAll();


    Optional<Product>findByTitleEquals(String title);

    @Override
    Optional<Product> findById(Long id);

    @Override
    void deleteById(Long id);
}
