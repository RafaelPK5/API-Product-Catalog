package com.product.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.demo.Models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
