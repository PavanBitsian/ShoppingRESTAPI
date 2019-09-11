package com.nanosoft.inventory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	public List<Inventory> getAllProductsInventory(){
		List<Inventory> inventory = new ArrayList();
		inventoryRepository.findAll().forEach(inventory::add);
		return inventory;
		
	}
	
	public Inventory getInventoryOfProduct(String productId) {
		//return products.stream().filter(p->p.getProductId().equals(productId)).findFirst().get();
		return inventoryRepository.findByProductId(productId);
	}
	
	
	public void addProductInventory(Inventory inventory) {
		//products.add(product);
		inventoryRepository.save(inventory);
	}
	
	
	public void updateProductInventory(Inventory inventory) {
//		Product product = products.stream().filter(p->p.getProductId().equals(productId)).findFirst().get();
//		product.setDescription(product.getDescription());
//		product.setProductName(product.getProductName());
		inventoryRepository.save(inventory);
	}
	
	public void deleteProductInventory(String productId) {
//		for(int i=products.size()-1;i>=0;--i) {
//			Product product = products.get(i);
//			if(product.getProductId().equals(productId)) {
//				products.remove(i);
//				break;
//			}
//		}
		inventoryRepository.delete(productId);
		//products.removeIf(t->t.getProductId().equals(productId));

	}
	
}
