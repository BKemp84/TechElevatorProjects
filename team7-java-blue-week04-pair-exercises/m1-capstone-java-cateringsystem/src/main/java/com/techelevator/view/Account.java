package com.techelevator.view;

public class Account {

	private double balance = 0;

	
	public void updateBalance(double amtToAdd) {

		balance += amtToAdd;
	}
	
	
	public double getBalance() {
		return balance;
	}
	


	
}
