package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Sellable;

public class Milk extends Item implements Sellable {

	private boolean isExpired = false;
	private double price;
	private double shippingCost;
	
	public Milk(double price, double shippingCost) {
		super(1, 2, "Milk");
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
	public boolean isOnSale() {
		return isExpired;
	}

	@Override
	public double getShippingCost() {
		if (isExpired) {
			return getBaseShippingCost();
		} else {
			return super.getShippingCost();
		}
	}

	@Override
	public boolean isDigital() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
