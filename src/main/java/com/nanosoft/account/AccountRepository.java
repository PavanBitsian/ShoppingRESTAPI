package com.nanosoft.account;


import org.springframework.data.repository.CrudRepository;



public interface AccountRepository  extends CrudRepository<Account, String>{
	public  Account findByUserId(String userId);
}
