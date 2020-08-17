package com.techelevator.cards;

public class CardDemo {

	public static void main(String[] args) {
		
		GolfCard card = new GolfCard("c", "T");
		
		System.out.println(card);
		
		card.flip();
		
		System.out.println(card);
		
		System.out.println(card.getValue());

	}

}
