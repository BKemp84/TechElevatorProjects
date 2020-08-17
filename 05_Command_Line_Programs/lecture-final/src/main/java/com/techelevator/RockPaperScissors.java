package com.techelevator;

import java.util.Scanner;

public class RockPaperScissors {

	/*
	 * Command Line programs follow this structure:  Take Input, Calculate Data, Give Output
	 * 
	 * How could we use this structure, with what we know of Java, so far, 
	 * to write a simple application like a Rock, Paper, Scissors game?
	 */
	public static void main(String[] args) {
		
		String[] choices = { "Rock", "Paper", "Scissors" };
		
		Scanner in = new Scanner(System.in);
		
		for ( ; true ; ) {
			System.out.println("Rock (0), Paper (1), or Scissors (2)");
			String userInput = in.nextLine();
			int userChoice = Integer.parseInt(userInput);
			
			int computerChoice = (int) (Math.random() * (2));
	
			System.out.println("You choose " + choices[userChoice] 
					+ " and the computer choose " + choices[computerChoice]);
			
			if (computerChoice == userChoice) {
				System.out.println("Tie!");
			} else if ( (userChoice == 0 && computerChoice == 2) ||
						(userChoice == 1 && computerChoice == 0) ||
						(userChoice == 2 && computerChoice == 1)) {  // Player can Win
				System.out.println("You won!");
			} else {
				System.out.println("The computer won!");
			}
			
			System.out.println("Do you want to play again?  Yes (0) or No (1)");
			int playAgain = in.nextInt();
			in.nextLine();
			if (playAgain == 1) {
				break;
			}
		}
			
		
	}
}
