package com.techelevator.cardExample;

import com.techelevator.cards.Card;
import com.techelevator.cards.Deck;

public class CardDemo {

	public static void main(String[] args) {
		
		Card aceOfSpades = new Card("Spades", "Ace");
		System.out.println(aceOfSpades);
		
		aceOfSpades.flip();
		
		System.out.println(aceOfSpades);
		
		Deck deck = new Deck();
		
		System.out.println( deck );
		
		deck.shuffle();
		
		System.out.println( deck );
		
		deck.cut(10);
		
		System.out.println( deck );

	}

}
