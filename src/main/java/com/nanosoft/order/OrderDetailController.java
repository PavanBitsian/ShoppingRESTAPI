package com.nanosoft.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nanosoft.product.Product;
import com.nanosoft.product.ProductService;

@RestController
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;

	@RequestMapping("/orderdetails")
	public List<OrderDetail> getAllProducts() {
		
		return orderDetailService.getAllOrders();
	}
	
	@RequestMapping("/orderdetails/{acctId}")
	public List<OrderDetail> getProduct(@PathVariable("acctId") String acctId) {
		return orderDetailService.getOrdersOfUser(acctId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/orderdetails")
	public String addOrder(@RequestBody OrderDetail orderDetail) {
		return orderDetailService.addOrder(orderDetail);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/orderdetails/{acctId}")
	public void updateOrder(@RequestBody OrderDetail orderDetail,@PathVariable String acctId) {
		orderDetailService.updateOrder(orderDetail);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/orderdetails/{orderId}")
	public void deleteProduct(@PathVariable String orderId) {
		orderDetailService.deleteOrder(orderId);
	}

}
