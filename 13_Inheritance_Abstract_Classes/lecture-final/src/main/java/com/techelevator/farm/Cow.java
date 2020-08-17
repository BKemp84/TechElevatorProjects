package com.techelevator.farm;

public class Cow extends FarmAnimal implements Sellable {

	public Cow() {
		super("Cow", "moo!");
	}

	@Override
	public int getPrice() {
		return 1000;
	}

	@Override
	public String eat() {
		return "chew";
	}

}