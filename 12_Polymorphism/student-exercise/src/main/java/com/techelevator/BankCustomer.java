package com.techelevator;

public class BankCustomer  implements Accountable{
	
	private String name;
	private String address;
	private String phoneNumber;
    private Accountable[] accounts;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public int getBalance() {
		return getBalance();
	}
	

	
	//public void addAccount(AccountableNewAccount) {
		
	
		//return  accounts = ; 
	public boolean isVip() {
		if (getBalance()   > 25000) {
			return true;
		}
		return false;
	}
	
	
	}


