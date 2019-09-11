package com.nanosoft.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nanosoft.product.Product;
import com.nanosoft.inventory.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;

	@RequestMapping("/inventory")
	public List<Inventory> getAllProductsInventory() {
		
		return inventoryService.getAllProductsInventory();
	}
	
	@RequestMapping("/inventory/{productId}")
	public Inventory getInventoryofProduct(@PathVariable("productId") String productId) {
		return inventoryService.getInventoryOfProduct(productId);
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/inventory")
	public void addProductInventory(@RequestBody Inventory inventory) {
		inventoryService.addProductInventory(inventory);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/inventory/{productId}")
	public void updateProduct(@RequestBody Inventory inventory,@PathVariable String productId) {
		inventoryService.updateProductInventory(inventory);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/inventory/{productId}")
	public void deleteProductInventory(@PathVariable String productId) {
		inventoryService.deleteProductInventory(productId);
	}
}
