package com.techelevator.tenmo.models;

import java.math.BigDecimal;

public class AddSubDto {
	private String userName = "";
	private BigDecimal amount = null; 
	private boolean isAddition;
	private BigDecimal currentBalance = null;
	
	public AddSubDto () {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean getIsAddition() {
		return isAddition;
	}

	public void setIsAddition(boolean isAddition) {
		this.isAddition = isAddition;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
}
