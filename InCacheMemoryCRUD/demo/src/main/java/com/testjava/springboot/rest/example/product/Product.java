package com.testjava.springboot.rest.example.product;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String productNumber;
	
	public Product() {
		super();
	}

	public Product(Long id, String name, String productNumber) {
		super();
		this.id = id;
		this.name = name;
		this.productNumber = productNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
		
}
