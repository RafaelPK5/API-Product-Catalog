package com.product.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.product.demo.Models.Product;
import com.product.demo.Models.User;
import com.product.demo.Repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

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

	public Product insert(Product obj) {
		return repository.save(obj);
	}

	public Product update(Long id, Product obj) {
		try {
		Product entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException();
		}
	}

	private void updateData(Product entity, Product obj) {
		System.out.println(obj.getImgUrl());
		entity.setName(obj.getName());
		entity.setPrice(obj.getPrice());
		entity.setDescription(obj.getDescription());
		entity.setImgUrl(obj.getImgUrl());
	}
}
