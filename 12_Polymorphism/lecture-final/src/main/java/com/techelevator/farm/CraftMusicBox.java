package com.techelevator.farm;

public class CraftMusicBox implements Singable, Sellable {

	@Override
	public int getPrice() {
		return 50;
	}

	@Override
	public String getName() {
		return "Music Box";
	}

	@Override
	public String getSound() {
		return "Ding Ding Ding Ding Ding Ding Ding";
	}

}
