package com.nanosoft.order;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetail {
	
	@Id
	private String orderId;
	private String prodId;
	private String acctId;
	private int quantity;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	

}
