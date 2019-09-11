package com.nanosoft.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanosoft.inventory.Inventory;
import com.nanosoft.inventory.InventoryRepository;
import com.nanosoft.inventory.InventoryService;
import com.nanosoft.product.Product;

@Service
public class OrderDetailService {
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private InventoryService inventoryService;
	
	Map<String,Inventory> invHM= new HashMap<String,Inventory>();
	
	public List<OrderDetail> getAllOrders(){
		List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
		orderDetailRepository.findAll().forEach(orderDetails::add);
		return orderDetails;
		
	}
	
	public List<OrderDetail> getOrdersOfUser(String acctId) {
		return orderDetailRepository.findByAcctId(acctId);
	}
	
	
	public String addOrder(OrderDetail orderDetail) {
		//products.add(product);
	System.out.println("start addOrder "+orderDetail.getProdId()+" "+orderDetail.getAcctId());
		
		String status = "Order creation failed. Product not found";
		Inventory inv = null;
		synchronized (this) {
			inv = invHM.get(orderDetail.getProdId());
			if(inv == null) {
				inv = inventoryRepository.findByProductId(orderDetail.getProdId());
				invHM.put(orderDetail.getProdId(), inv);
			}
		}
		/*inv object is used in synchronize block to ensure that multiple requests with same product id 
		 * always get the latest inventory details from database and helps to avoid Race condition. For example, lets say
		 * 2 incoming requests for the product id '12345' , map provides same inventory object for the product id '12345'
		 * to ensure object level lock so that second request will be able to get latest inventory details from db.
		 */
		if(inv != null) {
			synchronized(inv) { 
				Inventory currentInventory = inventoryRepository.findByProductId(orderDetail.getProdId());
				if(currentInventory != null && currentInventory.getQuantity() >= orderDetail.getQuantity()) {
					Inventory updatedInventory = new Inventory();
					updatedInventory.setProductId(orderDetail.getProdId());
					updatedInventory.setQuantity(currentInventory.getQuantity()-orderDetail.getQuantity());
					inventoryService.updateProductInventory(updatedInventory);
					status = "Order created successfully";
				}
				else {
					status = "Order creation failed, due to insufficient quantity";
				}
				orderDetailRepository.save(orderDetail);
			}
		}
		//System.out.println("end addOrder "+order.getProductId()+" "+order.getUserId());
		System.out.println("end addOrder "+orderDetail.getProdId()+" "+orderDetail.getAcctId());
		return status;
	}
	
	
	public void updateOrder(OrderDetail orderDetail) {
		orderDetailRepository.save(orderDetail);
	}
	
	public void deleteOrder(String orderId) {
		orderDetailRepository.delete(orderId);

	}

}
