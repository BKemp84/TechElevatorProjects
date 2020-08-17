package com.techelevator.ticket;

import java.math.BigDecimal;

public class VipTicket extends Ticket {

	private BigDecimal upCharge;
	
	public VipTicket(double price, double upCharge) {
		super(price);
		this.upCharge = new BigDecimal(upCharge);
	}
	
	@Override
	public BigDecimal getTotalPrice() {
		BigDecimal original = super.getTotalPrice();
		return original.add(upCharge);
	}
	
}
