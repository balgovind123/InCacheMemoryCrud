package com.testjava.springboot.rest.example.product;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProductResource {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> retrieveProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public Product retrieveProductsById(@PathVariable long id) {
		Optional<Product> student = productRepository.findById(id);

		if (!student.isPresent())
			throw new ProductNotFoundException("id-" + id);

		return student.get();
	}

	@DeleteMapping("/products/del/{id}")
	public void deleteProduct(@PathVariable long id) {
		productRepository.deleteById(id);
	}

	@PostMapping("/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		Product savedProduct = productRepository.save(product);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedProduct.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	

}
