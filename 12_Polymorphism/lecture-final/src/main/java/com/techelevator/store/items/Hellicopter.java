package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Sellable;

public class Hellicopter implements Sellable {

	private static final boolean isVeryCool = true;
	private int armorLevel;

	
	@Override
	public double getPrice() {
		return 1000000000.00;
	}
	@Override
	public String getName() {
		return "Arnold Swartzeneger's Hellicopter";
	}
	@Override
	public boolean isOnSale() {
		return true;
	}
	@Override
	public double getShippingCost() {
		return 0;
	}
	
}
