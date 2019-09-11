package com.nanosoft.account;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import com.nanosoft.order.OrderDetail;

@Entity
public class Account {

	@Id
	private String userId;
	private String address;
	
	@Transient @OneToMany
	private List<OrderDetail> orders;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<OrderDetail> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDetail> orders) {
		this.orders = orders;
	}
	
	
	
}
