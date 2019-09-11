package com.nanosoft.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList();
		productRepository.findAll().forEach(products::add);
		return products;
		
	}
	
	public Product getProduct(String productId) {
		//return products.stream().filter(p->p.getProductId().equals(productId)).findFirst().get();
		return productRepository.findOne(productId);
	}
	
	public List<Product> getProductByProductName(String productName) {
		//return products.stream().filter(p->p.getProductId().equals(productId)).findFirst().get();
		return productRepository.findByProductName(productName);
	}
	
	public void addProduct(Product product) {
		//products.add(product);
		productRepository.save(product);
	}
	
	
	public void updateProduct(Product product) {
//		Product product = products.stream().filter(p->p.getProductId().equals(productId)).findFirst().get();
//		product.setDescription(product.getDescription());
//		product.setProductName(product.getProductName());
		productRepository.save(product);
	}
	
	public void deleteProduct(String productId) {
//		for(int i=products.size()-1;i>=0;--i) {
//			Product product = products.get(i);
//			if(product.getProductId().equals(productId)) {
//				products.remove(i);
//				break;
//			}
//		}
		productRepository.delete(productId);
		//products.removeIf(t->t.getProductId().equals(productId));

	}

}
