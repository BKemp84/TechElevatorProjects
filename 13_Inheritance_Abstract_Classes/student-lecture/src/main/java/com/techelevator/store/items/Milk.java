package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Sellable;

public class Milk implements Sellable {

	private boolean isExpired = false;
	private double price;
	private double shippingCost;
	
	public Milk(double price, double shippingCost) {
		this.price = price;
		this.shippingCost = shippingCost;
	}
	
	public void setExpired() {
		isExpired = true;
	}
	
	
	@Override
	public double getPrice() {
		if (isExpired) {
			return price / 2;
		}
		return price;
	}

	@Override
	public String getName() {
		return "Milk";
	}

	@Override
	public boolean isOnSale() {
		return isExpired;
	}

	@Override
	public double getShippingCost() {

		return shippingCost;
	}
	
	
}
