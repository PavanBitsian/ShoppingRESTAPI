package com.nanosoft.account;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nanosoft.order.OrderDetailRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	

	
	public Account getAccountDetailsofUser(String userId){
		Account account = accountRepository.findByUserId(userId);
		if(account != null) {
			account.setOrders(orderDetailRepository.findByAcctId(userId));
		}
		return account;
		
	}
}
