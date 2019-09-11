package com.nanosoft.inventory;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Inventory {
	
	@Id
	String productId;
	long quantity;

	
	public Inventory() {
		// TODO Auto-generated constructor stub
	}


	


	public String getProductId() {
		return productId;
	}





	public void setProductId(String productId) {
		this.productId = productId;
	}





	public long getQuantity() {
		return quantity;
	}


	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
}
