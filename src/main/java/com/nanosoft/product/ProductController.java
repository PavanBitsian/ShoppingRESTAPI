package com.nanosoft.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/products")
	public List<Product> getAllProducts() {
		
		return productService.getAllProducts();
	}
	
	@RequestMapping("/products/{productId}")
	public Product getProduct(@PathVariable("productId") String productId) {
		return productService.getProduct(productId);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/products")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/products/{productId}")
	public void updateProduct(@RequestBody Product product,@PathVariable String productId) {
		productService.updateProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/products/{productId}")
	public void deleteProduct(@PathVariable String productId) {
		productService.deleteProduct(productId);
	}
	

}
