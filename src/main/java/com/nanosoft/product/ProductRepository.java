package com.nanosoft.product;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Product, String> {
	public  List<Product> findByProductName(String productName);
	public  List<Product> findByDescription(String desc);
	public  List<Product> findByProductId(String productId);
	public  List<Product> findAll();
}
