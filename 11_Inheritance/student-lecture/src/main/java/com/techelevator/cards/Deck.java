package com.techelevator.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private final static String[] SUITS = new String[] {"c", "s", "d", "h"};
	private final static String[] RANKS = new String[] { "A", "1", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
	
	private List<Card> listOfCards = new ArrayList<Card>();
	
	
	public Deck() {
		for (String suit : SUITS) {
			for (String rank: RANKS) {
				Card currentCard = new Card(suit, rank);
				listOfCards.add(currentCard);
			}
		}	
	}
	
	private void flip() {
		for (Card card: listOfCards) {
			card.flip();
		}
	}
	
	// Delegation Method
	public int size() {
		return listOfCards.size();
	}
	
	public Card deal() {
		if (size() > 0) {
			return listOfCards.remove(0);
		}
		return null;
	}
	
	public void shuffle() {
		// Get a random # between 0 and size-1
		// Remove the card at that index, and add it to another list
		
		// Keep cutting at a random position
		
		// Loop through the cards, 
		// for each pick a random # between 0 and 51
		// swap the card with that location in the array
		Collections.shuffle(listOfCards);
	}
	
	public void cut(int numberOfCards) {
		for (int i= 0; i < numberOfCards; i++) {
			Card cutCard = listOfCards.remove(0);
			listOfCards.add(cutCard);
		}
	}
	
	
	@Override
	public String toString() {
		flip();
		String stringRepresentation = "Deck [cards=" + listOfCards + "]";
		flip();
		return stringRepresentation;
	}
}
