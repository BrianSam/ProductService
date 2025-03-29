package com.brian.productservice.repositories;

import com.brian.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CategoryInterface extends JpaRepository<Category, Long> {
}
