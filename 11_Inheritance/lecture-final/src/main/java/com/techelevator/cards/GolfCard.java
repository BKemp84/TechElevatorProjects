package com.techelevator.cards;

public class GolfCard extends Card {

	public GolfCard(String suit, String rank) {
		super(suit, rank);
	}

	public int getValue() {
		int value = 0;
		if (super.getRank().equals("A")) {
			value = 1;
		} else if (getRank().equals("-2")) {
			value = -2;
		} else if (getRank().equals("J") || getRank().equals("Q") || getRank().equals("T")) {
			value = 10;
		} else if (getRank().equals("K")) {
			value = 0;
		} else {
			value = Integer.parseInt(getRank());
		}
		return value;
	}
	
}
