package com.techelevator.ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Ticket {

	private BigDecimal price;
	
	public Ticket(double price) {
		this.price = new BigDecimal(price);
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public BigDecimal getFee() {
		return price.multiply(new BigDecimal(.20));
	}
	
	public BigDecimal getTotalPrice() {
		BigDecimal totalCost = price.add(getFee());
		totalCost = totalCost.setScale(2, RoundingMode.HALF_UP);
		return totalCost;
	}
}
