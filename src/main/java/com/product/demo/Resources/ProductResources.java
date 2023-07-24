package com.product.demo.Resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.product.demo.Models.Product;
import com.product.demo.Models.User;
import com.product.demo.Services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {
    @Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findByID(@PathVariable Long id){
		Product obj = service.findByID(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Product> insert(@RequestBody Product obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
