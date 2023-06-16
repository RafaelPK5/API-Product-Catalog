package com.product.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.demo.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
}