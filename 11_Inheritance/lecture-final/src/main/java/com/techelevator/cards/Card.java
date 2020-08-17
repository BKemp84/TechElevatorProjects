package com.techelevator.cards;

public class Card {
	
	private String suit;
	private String rank;
	private boolean isFaceUp = false;
	
	public Card(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
	}

	public boolean flip() {
		isFaceUp = !isFaceUp;
		return isFaceUp;
	}
	
	
	public String getSuit() {
		return suit;
	}

	public String getRank() {
		return rank;
	}

	public boolean isFaceUp() {
		return isFaceUp;
	}
	
	@Override
	public String toString() {
		if (isFaceUp) {
			return rank + suit;
		} else {
			return "##";
		}
	}
	
}
