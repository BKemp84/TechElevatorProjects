package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Describable;
import com.techelevator.store.items.interfaces.Sellable;

public class Hellicopter extends Item implements Sellable {

	private static final boolean isVeryCool = true;
	private int armorLevel;

	public Hellicopter() {
		super(0,0, "Arnold Swartzeneger's Hellicopter");
	}
	
	@Override
	public double getPrice() {
		return 1000000000.00;
	}

	@Override
	public boolean isOnSale() {
		return true;
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
