package com.techelevator.farm;

public class Sheep extends FarmAnimal implements Sellable {

	public Sheep() {
		super("Sheep", "Baa");
	}

	@Override
	public int getPrice() {
		return 200;
	}
	
}
