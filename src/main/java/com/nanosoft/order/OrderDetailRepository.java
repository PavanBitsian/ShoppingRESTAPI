package com.nanosoft.order;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface OrderDetailRepository extends CrudRepository<OrderDetail, String>{
	
	public List<OrderDetail> findByAcctId(String acctId);

}
