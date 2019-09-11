package com.nanosoft.inventory;


import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface InventoryRepository extends CrudRepository<Inventory, String> {
	
	public  Inventory findByProductId(String productId);
	public  List<Inventory> findAll();

}
