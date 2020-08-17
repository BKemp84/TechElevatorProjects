package com.techelevator.tenmo.transfers;

import java.math.BigDecimal;

public class TransferDto {
	private int amount;
	private int accountSelection;
	private int reqSendSelection;
	
	public TransferDto() {
		
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAccountSelection() {
		return accountSelection;
	}

	public void setAccountSelection(int accountSelection) {
		this.accountSelection = accountSelection;
	}

	public int getReqSendSelection() {
		return reqSendSelection;
	}

	public void setReqSendSelection(int reqSendSelection) {
		this.reqSendSelection = reqSendSelection;
	}
	
	
}
