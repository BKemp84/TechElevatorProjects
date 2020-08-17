package com.techelevator.farm;

public class Apple implements Sellable {

	@Override
	public int getPrice() {
		return 1;
	}

	@Override
	public String getName() {
		return "Apple";
	}

}
