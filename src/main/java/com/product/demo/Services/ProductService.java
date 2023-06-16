package com.product.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.demo.Models.Product;
import com.product.demo.Repository.ProductRepository;

@Service
public class ProductService {
    	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findByID(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
}
