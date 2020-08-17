package com.techelevator.store.items;

import com.techelevator.store.items.interfaces.Sellable;

public class NewKidsOnTheBlockCd implements Sellable {

	private String albumTitle;
	private boolean isVeryCool = true;
	private int trackCount;
	
	public NewKidsOnTheBlockCd(String albumTitle, int trackCount) {
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
		return albumTitle;
	}
	
	@Override
	public boolean isOnSale() {
		return isVeryCool;
	}
	@Override
	public double getShippingCost() {
	
		return 1.5 * trackCount;
	}
	
}
