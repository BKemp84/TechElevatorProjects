package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Sellable;

public class Bread implements Sellable {

	private String type;

	private double price;
	private boolean isOnSale;
	private double shippingCost;

	public Bread(String type) {
		this.type = type;
	}
	
	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return type + " Bread";
	}

	@Override
	public boolean isOnSale() {
		return isOnSale;
	}

	@Override
	public double getShippingCost() {
		return shippingCost;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setOnSale(boolean isOnSale) {
		this.isOnSale = isOnSale;
	}

	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	
	
	
	
}
