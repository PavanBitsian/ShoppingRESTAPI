package com.nanosoft.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts/{userId}")
	public Account getAllOrdersofUser(@PathVariable("userId") String userId){
		Account account = accountService.getAccountDetailsofUser(userId);
		return account;
		
	}
}
