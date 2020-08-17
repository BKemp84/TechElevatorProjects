package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Sellable;

public class NewKidsOnTheBlockCd extends Item implements Sellable {

	private String albumTitle;
	private boolean isVeryCool = true;
	private int trackCount;
	
	public NewKidsOnTheBlockCd(String albumTitle, int trackCount) {
		super(2.0, 1, albumTitle);
		this.albumTitle = albumTitle;
		this.trackCount = trackCount;
	}
	
	public void setNotCool() {
		isVeryCool = false;
	}
	
	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 9.99;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return albumTitle + (isVeryCool ? "Is Cool!" : "Is No longer Cooler");
	}
	
	@Override
	public boolean isOnSale() {
		return isVeryCool;
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
