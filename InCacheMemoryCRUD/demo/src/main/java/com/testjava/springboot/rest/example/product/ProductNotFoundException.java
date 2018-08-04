package com.testjava.springboot.rest.example.product;



public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String exception) {
		
		super(exception);
		System.out.println("exeption");
	}

}
