package com.techelevator.farm;

public final class Cat extends FarmAnimal{

	public Cat() {
		super("Cat", "Meow");
	}

	@Override
	public String eat() {
		return "Cat biting";
	}

	
}
