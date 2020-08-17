package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.view.Account;

public class AccountTest {
	
	private Account account;
	
	@Before
	
	public void setup() {
		
		account = new Account();
		
	}
	
	
	@Test
	
	public void checkUpdateBalance() {
		
		account.updateBalance(10.10);
		
		Assert.assertEquals(10.10, account.getBalance(), 0.001);
		
	}
	
	
	
	
	
	

}
